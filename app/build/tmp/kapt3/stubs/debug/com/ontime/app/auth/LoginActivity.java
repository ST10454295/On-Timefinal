package com.ontime.app.auth;

/**
 * Screen 2: Login.
 *
 * Two ways in: email + password (Firebase Authentication hashes and
 * stores the password) or single sign-on with Google, which is linked
 * to the same Firebase account system.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/ontime/app/auth/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "auth$delegate", "Lkotlin/Lazy;", "binding", "Lcom/ontime/app/databinding/ActivityLoginBinding;", "googleLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "attemptLogin", "", "goHome", "handleGoogleResult", "data", "hideError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setLoading", "loading", "", "showError", "message", "", "startGoogleSignIn", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ontime.app.databinding.ActivityLoginBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy auth$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleLauncher = null;
    
    public LoginActivity() {
        super();
    }
    
    private final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void attemptLogin() {
    }
    
    private final void startGoogleSignIn() {
    }
    
    private final void handleGoogleResult(android.content.Intent data) {
    }
    
    private final void goHome() {
    }
    
    private final void setLoading(boolean loading) {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void hideError() {
    }
}