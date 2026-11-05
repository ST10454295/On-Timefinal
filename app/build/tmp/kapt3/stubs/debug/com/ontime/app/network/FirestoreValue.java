package com.ontime.app.network;

/**
 * Firestore's REST API represents every field as a typed wrapper object,
 * e.g. {"stringValue": "High"} rather than a plain JSON value. These
 * classes mirror that shape so Retrofit/Gson can (de)serialise it.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/ontime/app/network/FirestoreValue;", "", "stringValue", "", "integerValue", "doubleValue", "", "booleanValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getBooleanValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDoubleValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getIntegerValue", "()Ljava/lang/String;", "getStringValue", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/ontime/app/network/FirestoreValue;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class FirestoreValue {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String stringValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String integerValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double doubleValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean booleanValue = null;
    
    public FirestoreValue(@org.jetbrains.annotations.Nullable()
    java.lang.String stringValue, @org.jetbrains.annotations.Nullable()
    java.lang.String integerValue, @org.jetbrains.annotations.Nullable()
    java.lang.Double doubleValue, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean booleanValue) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStringValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIntegerValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getDoubleValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getBooleanValue() {
        return null;
    }
    
    public FirestoreValue() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ontime.app.network.FirestoreValue copy(@org.jetbrains.annotations.Nullable()
    java.lang.String stringValue, @org.jetbrains.annotations.Nullable()
    java.lang.String integerValue, @org.jetbrains.annotations.Nullable()
    java.lang.Double doubleValue, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean booleanValue) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}