package com.ontime.app.util

import android.content.Context

/**
 * Small on-device copy of the user's settings (SharedPreferences).
 * This is what lets Settings work offline - the same values are also
 * saved to Firestore, and pushed later if the phone was offline.
 */
class LocalPrefs(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences("ontime_prefs", Context.MODE_PRIVATE)

    var defaultDurationMinutes: Int
        get() = prefs.getInt(KEY_DURATION, 30)
        set(value) { prefs.edit().putInt(KEY_DURATION, value).apply() }

    var theme: String
        get() = prefs.getString(KEY_THEME, "Light") ?: "Light"
        set(value) { prefs.edit().putString(KEY_THEME, value).apply() }

    var language: String
        get() = prefs.getString(KEY_LANGUAGE, "en") ?: "en"
        set(value) { prefs.edit().putString(KEY_LANGUAGE, value).apply() }

    var notificationsEnabled: Boolean
        get() = prefs.getBoolean(KEY_NOTIFICATIONS, true)
        set(value) { prefs.edit().putBoolean(KEY_NOTIFICATIONS, value).apply() }

    var reminderMinutes: Int
        get() = prefs.getInt(KEY_REMINDER, 15)
        set(value) { prefs.edit().putInt(KEY_REMINDER, value).apply() }

    /** True when settings were changed on the phone but not yet uploaded. */
    var settingsDirty: Boolean
        get() = prefs.getBoolean(KEY_DIRTY, false)
        set(value) { prefs.edit().putBoolean(KEY_DIRTY, value).apply() }

    var fcmToken: String
        get() = prefs.getString(KEY_FCM, "") ?: ""
        set(value) { prefs.edit().putString(KEY_FCM, value).apply() }

    companion object {
        private const val KEY_DURATION = "default_duration"
        private const val KEY_THEME = "theme"
        private const val KEY_LANGUAGE = "language"
        private const val KEY_NOTIFICATIONS = "notifications_enabled"
        private const val KEY_REMINDER = "reminder_minutes"
        private const val KEY_DIRTY = "settings_dirty"
        private const val KEY_FCM = "fcm_token"
    }
}
