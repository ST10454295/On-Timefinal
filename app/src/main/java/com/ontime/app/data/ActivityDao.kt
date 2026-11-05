package com.ontime.app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ActivityDao {

    @Insert
    suspend fun insert(entity: ActivityEntity): Long

    @Query("SELECT * FROM activities WHERE uid = :uid ORDER BY date, startTime")
    suspend fun getAll(uid: String): List<ActivityEntity>

    @Query("SELECT * FROM activities WHERE uid = :uid AND date = :date ORDER BY startTime")
    suspend fun getForDate(uid: String, date: String): List<ActivityEntity>

    @Query("SELECT * FROM activities WHERE uid = :uid AND syncState = 'PENDING'")
    suspend fun getPending(uid: String): List<ActivityEntity>

    @Query("SELECT COUNT(*) FROM activities WHERE uid = :uid AND syncState = 'PENDING'")
    suspend fun countPending(uid: String): Int

    @Query("SELECT COUNT(*) FROM activities WHERE uid = :uid AND remoteId = :remoteId")
    suspend fun countByRemoteId(uid: String, remoteId: String): Int

    @Query("UPDATE activities SET remoteId = :remoteId, syncState = 'SYNCED' WHERE localId = :localId")
    suspend fun markSynced(localId: Long, remoteId: String)
}
