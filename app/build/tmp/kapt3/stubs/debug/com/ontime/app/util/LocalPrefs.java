package com.ontime.app.util;

/**
 * Small on-device copy of the user's settings (SharedPreferences).
 * This is what lets Settings work offline - the same values are also
 * saved to Firestore, and pushed later if the phone was offline.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \'2\u00020\u0001:\u0001\'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR$\u0010!\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR$\u0010$\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011\u00a8\u0006("}, d2 = {"Lcom/ontime/app/util/LocalPrefs;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "defaultDurationMinutes", "getDefaultDurationMinutes", "()I", "setDefaultDurationMinutes", "(I)V", "", "fcmToken", "getFcmToken", "()Ljava/lang/String;", "setFcmToken", "(Ljava/lang/String;)V", "language", "getLanguage", "setLanguage", "", "notificationsEnabled", "getNotificationsEnabled", "()Z", "setNotificationsEnabled", "(Z)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "reminderMinutes", "getReminderMinutes", "setReminderMinutes", "settingsDirty", "getSettingsDirty", "setSettingsDirty", "theme", "getTheme", "setTheme", "Companion", "app_debug"})
public final class LocalPrefs {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DURATION = "default_duration";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_THEME = "theme";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LANGUAGE = "language";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_NOTIFICATIONS = "notifications_enabled";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_REMINDER = "reminder_minutes";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DIRTY = "settings_dirty";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_FCM = "fcm_token";
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.util.LocalPrefs.Companion Companion = null;
    
    public LocalPrefs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final int getDefaultDurationMinutes() {
        return 0;
    }
    
    public final void setDefaultDurationMinutes(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTheme() {
        return null;
    }
    
    public final void setTheme(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    public final void setNotificationsEnabled(boolean value) {
    }
    
    public final int getReminderMinutes() {
        return 0;
    }
    
    public final void setReminderMinutes(int value) {
    }
    
    public final boolean getSettingsDirty() {
        return false;
    }
    
    public final void setSettingsDirty(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFcmToken() {
        return null;
    }
    
    public final void setFcmToken(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ontime/app/util/LocalPrefs$Companion;", "", "()V", "KEY_DIRTY", "", "KEY_DURATION", "KEY_FCM", "KEY_LANGUAGE", "KEY_NOTIFICATIONS", "KEY_REMINDER", "KEY_THEME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}