package com.ontime.app.sync

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.ontime.app.data.AppDatabase
import com.ontime.app.data.toEntity
import com.ontime.app.data.toFirestoreDocument
import com.ontime.app.network.AuthTokenProvider
import com.ontime.app.network.FirestoreClient
import com.ontime.app.network.documentId
import com.ontime.app.settings.SettingsRepository
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Offline-first synchronisation between the local Room database and
 * Firestore (over the REST API).
 *
 * 1. PUSH: every activity saved while offline (PENDING) is uploaded.
 * 2. PULL: any activity that exists in Firestore but not on the phone
 *    (e.g. added on another device) is copied into Room.
 * 3. Settings changed while offline are uploaded too.
 *
 * It is called after every save, when a screen opens, and automatically
 * when the phone regains a network connection (see OnTimeApp).
 */
object SyncManager {

    private const val TAG = "SyncManager"
    private const val PAGE_SIZE = 300
    private val mutex = Mutex()

    suspend fun syncIfLoggedIn(context: Context) {
        if (FirebaseAuth.getInstance().currentUser == null) return
        sync(context)
    }

    /** Returns true if the phone and Firestore are fully in sync afterwards, false if offline or failed. */
    suspend fun sync(context: Context): Boolean = mutex.withLock {
        val uid = FirebaseAuth.getInstance().currentUser?.uid
        if (uid == null) {
            Log.d(TAG, "No logged-in user - nothing to sync")
            return@withLock false
        }

        val appContext = context.applicationContext
        val dao = AppDatabase.getInstance(appContext).activityDao()

        try {
            val token = AuthTokenProvider.bearerToken()
            val collection = "${FirestoreClient.documentsRoot}/activities/$uid/items"

            // 1. Push offline activities
            val pending = dao.getPending(uid)
            Log.d(TAG, "Sync started - ${pending.size} activities waiting to upload")
            for (item in pending) {
                val created = FirestoreClient.api.createDocument(collection, token, item.toFirestoreDocument())
                val remoteId = created.documentId()
                    ?: throw IllegalStateException("Firestore did not return a document id")
                dao.markSynced(item.localId, remoteId)
                Log.d(TAG, "Uploaded '${item.title}' as $remoteId")
            }

            // 2. Pull anything new from the server
            val remote = FirestoreClient.api.listDocuments(collection, token, PAGE_SIZE).documents.orEmpty()
            var downloaded = 0
            for (doc in remote) {
                val remoteId = doc.documentId() ?: continue
                if (dao.countByRemoteId(uid, remoteId) > 0) continue
                val entity = doc.toEntity(uid, remoteId) ?: continue
                dao.insert(entity)
                downloaded++
            }
            Log.d(TAG, "Downloaded $downloaded new activities from Firestore")

            // 3. Settings saved while offline
            SettingsRepository(appContext).pushIfDirty()

            Log.d(TAG, "Sync finished OK")
            true
        } catch (e: Exception) {
            Log.w(TAG, "Sync failed (probably offline) - will retry when back online", e)
            false
        }
    }
}
