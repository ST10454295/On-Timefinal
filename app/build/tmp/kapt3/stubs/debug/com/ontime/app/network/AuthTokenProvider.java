package com.ontime.app.network;

/**
 * Firestore's REST API accepts a Firebase Auth ID token as a Bearer
 * token, so the same login from Firebase Auth authorises these REST
 * calls too - no separate backend login step needed.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/ontime/app/network/AuthTokenProvider;", "", "()V", "bearerToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentUid", "app_debug"})
public final class AuthTokenProvider {
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.network.AuthTokenProvider INSTANCE = null;
    
    private AuthTokenProvider() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object bearerToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String currentUid() {
        return null;
    }
}