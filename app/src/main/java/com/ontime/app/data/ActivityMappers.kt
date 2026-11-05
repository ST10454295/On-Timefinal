package com.ontime.app.data

import android.util.Log
import com.ontime.app.activities.ActivityItem
import com.ontime.app.activities.ActivityType
import com.ontime.app.logic.Importance
import com.ontime.app.network.FirestoreDocument
import com.ontime.app.network.FirestoreField
import com.ontime.app.network.getString

private const val TAG = "ActivityMappers"

fun ActivityItem.toEntity(uid: String): ActivityEntity = ActivityEntity(
    uid = uid,
    title = title,
    description = description,
    type = type.name,
    date = date,
    startTime = startTime,
    endTime = endTime,
    importance = importance.name,
    syncState = ActivityEntity.PENDING
)

fun ActivityEntity.toItem(): ActivityItem = ActivityItem(
    id = remoteId,
    title = title,
    description = description,
    type = parseType(type),
    date = date,
    startTime = startTime,
    endTime = endTime,
    importance = parseImportance(importance),
    pendingSync = syncState == ActivityEntity.PENDING
)

/** The Firestore (REST) representation of a local activity. */
fun ActivityEntity.toFirestoreDocument(): FirestoreDocument = FirestoreDocument(
    fields = mapOf(
        "title" to FirestoreField.of(title),
        "description" to FirestoreField.of(description),
        "type" to FirestoreField.of(type),
        "date" to FirestoreField.of(date),
        "startTime" to FirestoreField.of(startTime),
        "endTime" to FirestoreField.of(endTime),
        "importance" to FirestoreField.of(importance)
    )
)

/** Turns a Firestore document into a local, already-synced activity (null if it is missing required fields). */
fun FirestoreDocument.toEntity(uid: String, remoteId: String): ActivityEntity? {
    val title = fields.getString("title") ?: return null
    val date = fields.getString("date") ?: return null
    val startTime = fields.getString("startTime") ?: return null
    val endTime = fields.getString("endTime") ?: return null
    val importance = fields.getString("importance") ?: return null
    return ActivityEntity(
        remoteId = remoteId,
        uid = uid,
        title = title,
        description = fields.getString("description") ?: "",
        type = fields.getString("type") ?: ActivityType.OTHER.name,
        date = date,
        startTime = startTime,
        endTime = endTime,
        importance = importance,
        syncState = ActivityEntity.SYNCED
    )
}

private fun parseType(raw: String): ActivityType = try {
    ActivityType.valueOf(raw)
} catch (e: IllegalArgumentException) {
    Log.e(TAG, "Unknown activity type '$raw' - using OTHER", e)
    ActivityType.OTHER
}

private fun parseImportance(raw: String): Importance = try {
    Importance.valueOf(raw)
} catch (e: IllegalArgumentException) {
    Log.e(TAG, "Unknown importance '$raw' - using LOW", e)
    Importance.LOW
}
