package com.ontime.app;

/**
 * Screen 4: Dashboard.
 *
 * Shows today's activities (read from the local Room database, so it
 * works offline), how many are still waiting to sync, and links to Add
 * Activity, Calendar, Settings and Log Out. Also asks for the
 * notification permission and registers this phone for push messages.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u000e\u0010\u0018\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00070\u00070\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/ontime/app/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ontime/app/databinding/ActivityHomeBinding;", "listAdapter", "Landroid/widget/ArrayAdapter;", "", "permissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "repository", "Lcom/ontime/app/activities/ActivityRepository;", "getRepository", "()Lcom/ontime/app/activities/ActivityRepository;", "repository$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "registerPushToken", "requestNotificationPermission", "showToday", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ontime.app.databinding.ActivityHomeBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    private android.widget.ArrayAdapter<java.lang.String> listAdapter;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> permissionLauncher = null;
    
    public HomeActivity() {
        super();
    }
    
    private final com.ontime.app.activities.ActivityRepository getRepository() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final java.lang.Object showToday(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void requestNotificationPermission() {
    }
    
    private final void registerPushToken() {
    }
}