package com.ontime.app.logic;

/**
 * The importance system described in the plan: when a new activity is
 * added, compare it against existing activities on the same day and
 * report the most severe conflict, if any.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00070\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/ontime/app/logic/ConflictChecker;", "", "()V", "mostSevereConflict", "Lcom/ontime/app/logic/Importance;", "existing", "", "Lkotlin/Pair;", "Lcom/ontime/app/logic/TimeRange;", "newRange", "overlaps", "", "a", "b", "severity", "", "importance", "app_debug"})
public final class ConflictChecker {
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.logic.ConflictChecker INSTANCE = null;
    
    private ConflictChecker() {
        super();
    }
    
    private final boolean overlaps(com.ontime.app.logic.TimeRange a, com.ontime.app.logic.TimeRange b) {
        return false;
    }
    
    private final int severity(com.ontime.app.logic.Importance importance) {
        return 0;
    }
    
    /**
     * Returns the importance level of the most severe existing activity
     * that overlaps [newRange], or null if there's no conflict.
     */
    @org.jetbrains.annotations.Nullable()
    public final com.ontime.app.logic.Importance mostSevereConflict(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends kotlin.Pair<com.ontime.app.logic.TimeRange, ? extends com.ontime.app.logic.Importance>> existing, @org.jetbrains.annotations.NotNull()
    com.ontime.app.logic.TimeRange newRange) {
        return null;
    }
}