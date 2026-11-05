package com.ontime.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * One activity stored in the local Room database (the offline copy).
 *
 * syncState is PENDING while the activity only exists on the phone,
 * and SYNCED once it has been uploaded to Firestore (remoteId is then
 * the Firestore document id).
 */
@Entity(tableName = "activities")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true) val localId: Long = 0,
    val remoteId: String? = null,
    val uid: String,
    val title: String,
    val description: String,
    val type: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val importance: String,
    val syncState: String
) {
    companion object {
        const val PENDING = "PENDING"
        const val SYNCED = "SYNCED"
    }
}
