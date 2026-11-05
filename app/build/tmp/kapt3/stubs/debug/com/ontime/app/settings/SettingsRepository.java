package com.ontime.app.settings;

/**
 * Reads and writes the current user's settings. They are always kept on
 * the phone (so Settings works offline) and also saved to Firestore over
 * the REST API, at settings/{uid}. If the upload fails, the settings are
 * flagged and uploaded by SyncManager when the phone is back online.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u000e\u0010\u0017\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/ontime/app/settings/SettingsRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Lcom/ontime/app/util/LocalPrefs;", "documentPath", "", "uid", "load", "Lcom/ontime/app/settings/UserSettings;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLocal", "pushIfDirty", "", "save", "", "settings", "(Lcom/ontime/app/settings/UserSettings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLocal", "toDocument", "Lcom/ontime/app/network/FirestoreDocument;", "uploadLocal", "Companion", "app_debug"})
public final class SettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.ontime.app.util.LocalPrefs prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SettingsRepository";
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.settings.SettingsRepository.Companion Companion = null;
    
    public SettingsRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final java.lang.String documentPath(java.lang.String uid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ontime.app.settings.UserSettings loadLocal() {
        return null;
    }
    
    private final void saveLocal(com.ontime.app.settings.UserSettings settings) {
    }
    
    private final com.ontime.app.network.FirestoreDocument toDocument(com.ontime.app.settings.UserSettings settings) {
        return null;
    }
    
    /**
     * Saves on the phone, then tries Firestore. Returns true if the upload worked.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull()
    com.ontime.app.settings.UserSettings settings, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Called by SyncManager: uploads settings that were saved while offline.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pushIfDirty(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object uploadLocal(kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Latest settings from Firestore if reachable, otherwise the on-phone copy.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ontime.app.settings.UserSettings> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/ontime/app/settings/SettingsRepository$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}