package com.ontime.app.network;

/**
 * This is the app's RESTful API layer: plain HTTPS calls (via Retrofit,
 * the external library) to Google's hosted Firestore REST API, carrying
 * a Firebase Auth ID token for authorisation. No Firebase SDK is used
 * here for reading/writing data - only for authentication.
 *
 * Firestore REST reference: https://firestore.googleapis.com/v1/{path}
 * where {path} is "projects/{projectId}/databases/(default)/documents/..."
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\fJ,\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0012J,\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/ontime/app/network/FirestoreApi;", "", "createDocument", "Lcom/ontime/app/network/FirestoreDocument;", "collectionPath", "", "authorization", "document", "(Ljava/lang/String;Ljava/lang/String;Lcom/ontime/app/network/FirestoreDocument;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDocument", "", "path", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDocument", "listDocuments", "Lcom/ontime/app/network/FirestoreListResponse;", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDocument", "app_debug"})
public abstract interface FirestoreApi {
    
    @retrofit2.http.GET(value = "v1/{path}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDocument(@retrofit2.http.Path(value = "path", encoded = true)
    @org.jetbrains.annotations.NotNull()
    java.lang.String path, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ontime.app.network.FirestoreDocument> $completion);
    
    @retrofit2.http.GET(value = "v1/{path}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object listDocuments(@retrofit2.http.Path(value = "path", encoded = true)
    @org.jetbrains.annotations.NotNull()
    java.lang.String path, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Query(value = "pageSize")
    int pageSize, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ontime.app.network.FirestoreListResponse> $completion);
    
    /**
     * Creates a document with a specific, known id (used for one-per-user Settings).
     */
    @retrofit2.http.PATCH(value = "v1/{path}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object setDocument(@retrofit2.http.Path(value = "path", encoded = true)
    @org.jetbrains.annotations.NotNull()
    java.lang.String path, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.ontime.app.network.FirestoreDocument document, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ontime.app.network.FirestoreDocument> $completion);
    
    /**
     * Creates a document with an auto-generated id inside a collection (used for Activities).
     */
    @retrofit2.http.POST(value = "v1/{collectionPath}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createDocument(@retrofit2.http.Path(value = "collectionPath", encoded = true)
    @org.jetbrains.annotations.NotNull()
    java.lang.String collectionPath, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.ontime.app.network.FirestoreDocument document, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ontime.app.network.FirestoreDocument> $completion);
    
    @retrofit2.http.DELETE(value = "v1/{path}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteDocument(@retrofit2.http.Path(value = "path", encoded = true)
    @org.jetbrains.annotations.NotNull()
    java.lang.String path, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}