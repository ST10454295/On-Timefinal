package com.ontime.app.settings

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.ontime.app.network.AuthTokenProvider
import com.ontime.app.network.FirestoreClient
import com.ontime.app.network.FirestoreDocument
import com.ontime.app.network.FirestoreField
import com.ontime.app.network.getBool
import com.ontime.app.network.getInt
import com.ontime.app.network.getString
import com.ontime.app.util.LocalPrefs

data class UserSettings(
    val defaultDurationMinutes: Int = 30,
    val theme: String = "Light",        // "Light" or "Dark"
    val language: String = "en",        // "en", "zu" or "xh"
    val notificationsEnabled: Boolean = true,
    val reminderMinutes: Int = 15
)

/**
 * Reads and writes the current user's settings. They are always kept on
 * the phone (so Settings works offline) and also saved to Firestore over
 * the REST API, at settings/{uid}. If the upload fails, the settings are
 * flagged and uploaded by SyncManager when the phone is back online.
 */
class SettingsRepository(context: Context) {

    private val prefs = LocalPrefs(context)

    private fun documentPath(uid: String) = "${FirestoreClient.documentsRoot}/settings/$uid"

    fun loadLocal(): UserSettings = UserSettings(
        defaultDurationMinutes = prefs.defaultDurationMinutes,
        theme = prefs.theme,
        language = prefs.language,
        notificationsEnabled = prefs.notificationsEnabled,
        reminderMinutes = prefs.reminderMinutes
    )

    private fun saveLocal(settings: UserSettings) {
        prefs.defaultDurationMinutes = settings.defaultDurationMinutes
        prefs.theme = settings.theme
        prefs.language = settings.language
        prefs.notificationsEnabled = settings.notificationsEnabled
        prefs.reminderMinutes = settings.reminderMinutes
    }

    private fun toDocument(settings: UserSettings) = FirestoreDocument(
        fields = mapOf(
            "defaultDurationMinutes" to FirestoreField.of(settings.defaultDurationMinutes),
            "theme" to FirestoreField.of(settings.theme),
            "language" to FirestoreField.of(settings.language),
            "notificationsEnabled" to FirestoreField.of(settings.notificationsEnabled),
            "reminderMinutes" to FirestoreField.of(settings.reminderMinutes)
        )
    )

    /** Saves on the phone, then tries Firestore. Returns true if the upload worked. */
    suspend fun save(settings: UserSettings): Boolean {
        saveLocal(settings)
        prefs.settingsDirty = true
        return uploadLocal()
    }

    /** Called by SyncManager: uploads settings that were saved while offline. */
    suspend fun pushIfDirty() {
        if (!prefs.settingsDirty) return
        uploadLocal()
    }

    private suspend fun uploadLocal(): Boolean {
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return false
        return try {
            val token = AuthTokenProvider.bearerToken()
            FirestoreClient.api.setDocument(documentPath(uid), token, toDocument(loadLocal()))
            prefs.settingsDirty = false
            Log.d(TAG, "Settings uploaded to Firestore")
            true
        } catch (e: Exception) {
            Log.w(TAG, "Settings upload failed (offline?) - kept on the phone", e)
            false
        }
    }

    /** Latest settings from Firestore if reachable, otherwise the on-phone copy. */
    suspend fun load(): UserSettings {
        if (prefs.settingsDirty) return loadLocal()
        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return loadLocal()
        return try {
            val token = AuthTokenProvider.bearerToken()
            val document = FirestoreClient.api.getDocument(documentPath(uid), token)
            val remote = UserSettings(
                defaultDurationMinutes = document.fields.getInt("defaultDurationMinutes") ?: 30,
                theme = document.fields.getString("theme") ?: "Light",
                language = document.fields.getString("language") ?: "en",
                notificationsEnabled = document.fields.getBool("notificationsEnabled") ?: true,
                reminderMinutes = document.fields.getInt("reminderMinutes") ?: 15
            )
            saveLocal(remote)
            remote
        } catch (e: Exception) {
            Log.d(TAG, "No remote settings available - using the on-phone copy", e)
            loadLocal()
        }
    }

    companion object {
        private const val TAG = "SettingsRepository"
    }
}
