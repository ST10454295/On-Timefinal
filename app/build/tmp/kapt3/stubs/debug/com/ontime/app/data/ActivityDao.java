package com.ontime.app.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\tJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/ontime/app/data/ActivityDao;", "", "countByRemoteId", "", "uid", "", "remoteId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countPending", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "", "Lcom/ontime/app/data/ActivityEntity;", "getForDate", "date", "getPending", "insert", "", "entity", "(Lcom/ontime/app/data/ActivityEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markSynced", "", "localId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ActivityDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.ontime.app.data.ActivityEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM activities WHERE uid = :uid ORDER BY date, startTime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ontime.app.data.ActivityEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM activities WHERE uid = :uid AND date = :date ORDER BY startTime")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ontime.app.data.ActivityEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM activities WHERE uid = :uid AND syncState = \'PENDING\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPending(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ontime.app.data.ActivityEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM activities WHERE uid = :uid AND syncState = \'PENDING\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countPending(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM activities WHERE uid = :uid AND remoteId = :remoteId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countByRemoteId(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String remoteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "UPDATE activities SET remoteId = :remoteId, syncState = \'SYNCED\' WHERE localId = :localId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markSynced(long localId, @org.jetbrains.annotations.NotNull()
    java.lang.String remoteId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}