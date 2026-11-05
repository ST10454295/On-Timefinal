package com.ontime.app.logic;

/**
 * Works out when a reminder notification should fire. Plain Kotlin with
 * no Android dependencies, so it can be unit tested.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/ontime/app/logic/ReminderCalculator;", "", "()V", "triggerTimeMillis", "", "date", "", "startTime", "minutesBefore", "", "nowMillis", "(Ljava/lang/String;Ljava/lang/String;IJ)Ljava/lang/Long;", "app_debug"})
public final class ReminderCalculator {
    @org.jetbrains.annotations.NotNull()
    public static final com.ontime.app.logic.ReminderCalculator INSTANCE = null;
    
    private ReminderCalculator() {
        super();
    }
    
    /**
     * @return the time (epoch millis) to notify, or null if the date/time is
     * malformed or the reminder time has already passed.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long triggerTimeMillis(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.lang.String startTime, int minutesBefore, long nowMillis) {
        return null;
    }
}