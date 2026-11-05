package com.ontime.app.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u0001\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a\n\u0010\r\u001a\u00020\u000b*\u00020\b\u001a\n\u0010\u000e\u001a\u00020\t*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"TAG", "", "parseImportance", "Lcom/ontime/app/logic/Importance;", "raw", "parseType", "Lcom/ontime/app/activities/ActivityType;", "toEntity", "Lcom/ontime/app/data/ActivityEntity;", "Lcom/ontime/app/activities/ActivityItem;", "uid", "Lcom/ontime/app/network/FirestoreDocument;", "remoteId", "toFirestoreDocument", "toItem", "app_debug"})
public final class ActivityMappersKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ActivityMappers";
    
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.data.ActivityEntity toEntity(@org.jetbrains.annotations.NotNull()
    com.ontime.app.activities.ActivityItem $this$toEntity, @org.jetbrains.annotations.NotNull()
    java.lang.String uid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.activities.ActivityItem toItem(@org.jetbrains.annotations.NotNull()
    com.ontime.app.data.ActivityEntity $this$toItem) {
        return null;
    }
    
    /**
     * The Firestore (REST) representation of a local activity.
     */
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.network.FirestoreDocument toFirestoreDocument(@org.jetbrains.annotations.NotNull()
    com.ontime.app.data.ActivityEntity $this$toFirestoreDocument) {
        return null;
    }
    
    /**
     * Turns a Firestore document into a local, already-synced activity (null if it is missing required fields).
     */
    @org.jetbrains.annotations.Nullable()
    public static final com.ontime.app.data.ActivityEntity toEntity(@org.jetbrains.annotations.NotNull()
    com.ontime.app.network.FirestoreDocument $this$toEntity, @org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String remoteId) {
        return null;
    }
    
    private static final com.ontime.app.activities.ActivityType parseType(java.lang.String raw) {
        return null;
    }
    
    private static final com.ontime.app.logic.Importance parseImportance(java.lang.String raw) {
        return null;
    }
}