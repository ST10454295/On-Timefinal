package com.ontime.app.auth;

/**
 * Screen 3: Register.
 *
 * Creates an account with Firebase Authentication. Firebase handles
 * password hashing/encryption and hosting the account data itself -
 * this is what satisfies the "encrypt the password" and "hosted
 * database" requirements without us running our own server.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u000e\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J*\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/ontime/app/auth/RegisterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "auth$delegate", "Lkotlin/Lazy;", "binding", "Lcom/ontime/app/databinding/ActivityRegisterBinding;", "attemptRegister", "", "hideError", "onAccountCreated", "task", "Lcom/google/android/gms/tasks/Task;", "fullName", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setLoading", "loading", "", "showError", "message", "validate", "email", "password", "confirmPassword", "app_debug"})
public final class RegisterActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ontime.app.databinding.ActivityRegisterBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy auth$delegate = null;
    
    public RegisterActivity() {
        super();
    }
    
    private final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void attemptRegister() {
    }
    
    private final void onAccountCreated(com.google.android.gms.tasks.Task<?> task, java.lang.String fullName) {
    }
    
    private final java.lang.String validate(java.lang.String fullName, java.lang.String email, java.lang.String password, java.lang.String confirmPassword) {
        return null;
    }
    
    private final void setLoading(boolean loading) {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void hideError() {
    }
}