package com.ontime.app.calendar;

/**
 * Screen 7: Calendar.
 *
 * Pick a day to see that day's activities. Reads from the local Room
 * database, so it also works offline.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/ontime/app/calendar/CalendarActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ontime/app/databinding/ActivityCalendarBinding;", "dateFormat", "Ljava/text/SimpleDateFormat;", "listAdapter", "Landroid/widget/ArrayAdapter;", "", "repository", "Lcom/ontime/app/activities/ActivityRepository;", "getRepository", "()Lcom/ontime/app/activities/ActivityRepository;", "repository$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showDay", "date", "app_debug"})
public final class CalendarActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ontime.app.databinding.ActivityCalendarBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    private android.widget.ArrayAdapter<java.lang.String> listAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    
    public CalendarActivity() {
        super();
    }
    
    private final com.ontime.app.activities.ActivityRepository getRepository() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showDay(java.lang.String date) {
    }
}