package com.ontime.app.settings;

/**
 * Screen 8: Settings.
 *
 * Default duration, theme (light/dark), language (English, isiZulu,
 * isiXhosa), reminder notifications, plus buttons to test push
 * notifications. Saved on the phone (works offline) and to Firestore
 * through the REST API.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006$"}, d2 = {"Lcom/ontime/app/settings/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ontime/app/databinding/ActivitySettingsBinding;", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "repository", "Lcom/ontime/app/settings/SettingsRepository;", "getRepository", "()Lcom/ontime/app/settings/SettingsRepository;", "repository$delegate", "Lkotlin/Lazy;", "applyAppearance", "", "settings", "Lcom/ontime/app/settings/UserSettings;", "copyPushToken", "loadSettings", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTestNotificationClicked", "saveSettings", "selectedLanguage", "Lcom/ontime/app/logic/AppLanguage;", "sendTestNotification", "setLoading", "loading", "", "showSettings", "showStatus", "message", "isError", "app_debug"})
public final class SettingsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ontime.app.databinding.ActivitySettingsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> permissionLauncher = null;
    
    public SettingsActivity() {
        super();
    }
    
    private final com.ontime.app.settings.SettingsRepository getRepository() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadSettings() {
    }
    
    private final void showSettings(com.ontime.app.settings.UserSettings settings) {
    }
    
    private final com.ontime.app.logic.AppLanguage selectedLanguage() {
        return null;
    }
    
    private final void saveSettings() {
    }
    
    /**
     * Switches theme and language straight away. Android recreates the screens, so this runs last.
     */
    private final void applyAppearance(com.ontime.app.settings.UserSettings settings) {
    }
    
    private final void onTestNotificationClicked() {
    }
    
    private final void sendTestNotification() {
    }
    
    private final void copyPushToken() {
    }
    
    private final void setLoading(boolean loading) {
    }
    
    private final void showStatus(java.lang.String message, boolean isError) {
    }
}