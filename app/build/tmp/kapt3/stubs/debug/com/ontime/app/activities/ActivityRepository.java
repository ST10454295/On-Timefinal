package com.ontime.app.activities;

/**
 * Offline-first: every read and write goes through the local Room
 * database, so the app works with no connection. SyncManager keeps
 * Room and Firestore (the REST API) in step.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0017\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/ontime/app/activities/ActivityRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "dao", "Lcom/ontime/app/data/ActivityDao;", "add", "", "activity", "Lcom/ontime/app/activities/ActivityItem;", "(Lcom/ontime/app/activities/ActivityItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listForDate", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendingCount", "", "syncNow", "uid", "app_debug"})
public final class ActivityRepository {
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ontime.app.data.ActivityDao dao = null;
    
    public ActivityRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final java.lang.String uid() {
        return null;
    }
    
    /**
     * Saves locally first, then tries to upload. Returns true if it already reached the server.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object add(@org.jetbrains.annotations.NotNull()
    com.ontime.app.activities.ActivityItem activity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ontime.app.activities.ActivityItem>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ontime.app.activities.ActivityItem>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pendingCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncNow(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}