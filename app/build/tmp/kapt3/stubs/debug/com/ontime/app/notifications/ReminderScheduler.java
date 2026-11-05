package com.ontime.app.notifications;

/**
 * Schedules a reminder notification before an activity starts, using the
 * "minutes before" value from Settings. Uses an inexact alarm, which
 * needs no special permission.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/ontime/app/notifications/ReminderScheduler;", "", "()V", "EXTRA_START", "", "EXTRA_TITLE", "TAG", "schedule", "", "context", "Landroid/content/Context;", "title", "date", "startTime", "app_debug"})
public final class ReminderScheduler {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ReminderScheduler";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TITLE = "extra_title";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_START = "extra_start";
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.notifications.ReminderScheduler INSTANCE = null;
    
    private ReminderScheduler() {
        super();
    }
    
    public final void schedule(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String startTime) {
    }
}