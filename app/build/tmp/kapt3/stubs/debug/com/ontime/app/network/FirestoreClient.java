package com.ontime.app.network;

/**
 * Single Retrofit instance for talking to the Firestore REST API.
 *
 * PROJECT_ID must match the "project_id" in google-services.json.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/ontime/app/network/FirestoreClient;", "", "()V", "BASE_URL", "", "PROJECT_ID", "api", "Lcom/ontime/app/network/FirestoreApi;", "getApi", "()Lcom/ontime/app/network/FirestoreApi;", "api$delegate", "Lkotlin/Lazy;", "documentsRoot", "getDocumentsRoot", "()Ljava/lang/String;", "app_debug"})
public final class FirestoreClient {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROJECT_ID = "ontime-9455a";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://firestore.googleapis.com/";
    
    /**
     * e.g. "projects/ontime-9455a/databases/(default)/documents"
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String documentsRoot = "projects/ontime-9455a/databases/(default)/documents";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy api$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.network.FirestoreClient INSTANCE = null;
    
    private FirestoreClient() {
        super();
    }
    
    /**
     * e.g. "projects/ontime-9455a/databases/(default)/documents"
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentsRoot() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ontime.app.network.FirestoreApi getApi() {
        return null;
    }
}