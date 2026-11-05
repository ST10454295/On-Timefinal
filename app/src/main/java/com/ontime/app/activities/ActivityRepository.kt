package com.ontime.app.activities

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.ontime.app.data.AppDatabase
import com.ontime.app.data.toEntity
import com.ontime.app.data.toItem
import com.ontime.app.logic.Importance
import com.ontime.app.sync.SyncManager

/**
 * One activity the user has scheduled - matches 3.2 of the planning
 * document: title, description, date, start/end time, type and
 * importance level. pendingSync is true while it only exists on the phone.
 */
data class ActivityItem(
    val id: String? = null,
    val title: String,
    val description: String,
    val type: ActivityType,
    val date: String,        // "YYYY-MM-DD"
    val startTime: String,   // "HH:mm"
    val endTime: String,     // "HH:mm"
    val importance: Importance,
    val pendingSync: Boolean = false
)

/**
 * Offline-first: every read and write goes through the local Room
 * database, so the app works with no connection. SyncManager keeps
 * Room and Firestore (the REST API) in step.
 */
class ActivityRepository(context: Context) {

    private val appContext = context.applicationContext
    private val dao = AppDatabase.getInstance(appContext).activityDao()

    private fun uid(): String =
        FirebaseAuth.getInstance().currentUser?.uid
            ?: throw IllegalStateException("No user is logged in")

    /** Saves locally first, then tries to upload. Returns true if it already reached the server. */
    suspend fun add(activity: ActivityItem): Boolean {
        dao.insert(activity.toEntity(uid()))
        return SyncManager.sync(appContext)
    }

    suspend fun listAll(): List<ActivityItem> = dao.getAll(uid()).map { it.toItem() }

    suspend fun listForDate(date: String): List<ActivityItem> =
        dao.getForDate(uid(), date).map { it.toItem() }

    suspend fun pendingCount(): Int = dao.countPending(uid())

    suspend fun syncNow(): Boolean = SyncManager.sync(appContext)
}
