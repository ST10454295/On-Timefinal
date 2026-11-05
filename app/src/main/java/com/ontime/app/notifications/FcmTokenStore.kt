package com.ontime.app.notifications

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.ontime.app.network.AuthTokenProvider
import com.ontime.app.network.FirestoreClient
import com.ontime.app.network.FirestoreDocument
import com.ontime.app.network.FirestoreField

/** Saves this phone's push (FCM) token to Firestore so messages can be sent to the user. */
object FcmTokenStore {

    private const val TAG = "FcmTokenStore"

    suspend fun saveForCurrentUser(token: String) {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return
        try {
            val bearer = AuthTokenProvider.bearerToken()
            val document = FirestoreDocument(fields = mapOf("token" to FirestoreField.of(token)))
            FirestoreClient.api.setDocument(
                "${FirestoreClient.documentsRoot}/fcmTokens/$uid",
                bearer,
                document
            )
            Log.d(TAG, "Push token saved for uid=$uid")
        } catch (e: Exception) {
            Log.w(TAG, "Couldn't save push token (offline?) - will retry next launch", e)
        }
    }
}
