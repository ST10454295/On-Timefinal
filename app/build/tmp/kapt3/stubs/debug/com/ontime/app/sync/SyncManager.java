package com.ontime.app.sync;

/**
 * Offline-first synchronisation between the local Room database and
 * Firestore (over the REST API).
 *
 * 1. PUSH: every activity saved while offline (PENDING) is uploaded.
 * 2. PULL: any activity that exists in Firestore but not on the phone
 *   (e.g. added on another device) is copied into Room.
 * 3. Settings changed while offline are uploaded too.
 *
 * It is called after every save, when a screen opens, and automatically
 * when the phone regains a network connection (see OnTimeApp).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/ontime/app/sync/SyncManager;", "", "()V", "PAGE_SIZE", "", "TAG", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "sync", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncIfLoggedIn", "", "app_debug"})
public final class SyncManager {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SyncManager";
    private static final int PAGE_SIZE = 300;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.sync.Mutex mutex = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.sync.SyncManager INSTANCE = null;
    
    private SyncManager() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncIfLoggedIn(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Returns true if the phone and Firestore are fully in sync afterwards, false if offline or failed.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sync(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}