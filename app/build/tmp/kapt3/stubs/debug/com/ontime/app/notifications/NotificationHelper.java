package com.ontime.app.notifications;

/**
 * Creates the notification channel and shows notifications (reminders, push messages, test).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ(\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/ontime/app/notifications/NotificationHelper;", "", "()V", "CHANNEL_ID", "", "TAG", "createChannel", "", "context", "Landroid/content/Context;", "hasPermission", "", "show", "title", "body", "notificationId", "", "app_debug"})
public final class NotificationHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "NotificationHelper";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "ontime_reminders";
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.notifications.NotificationHelper INSTANCE = null;
    
    private NotificationHelper() {
        super();
    }
    
    public final void createChannel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final boolean hasPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void show(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String body, int notificationId) {
    }
}