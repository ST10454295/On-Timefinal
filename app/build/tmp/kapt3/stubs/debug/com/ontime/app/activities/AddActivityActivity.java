package com.ontime.app.activities;

/**
 * Screen 5: Add Activity.
 *
 * Works offline: activities are saved to the local Room database first
 * and uploaded to Firestore as soon as there is a connection. The
 * conflict check (High/Medium/Low importance) runs against the local
 * copy, so it works offline too. A reminder notification is scheduled
 * using the "minutes before" value from Settings.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010\'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002J\u001e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0-H\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u000fH\u0002J\u001c\u00100\u001a\u00020\u001c2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001c02H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/ontime/app/activities/AddActivityActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ontime/app/databinding/ActivityAddActivityBinding;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "dateFormat", "Ljava/text/SimpleDateFormat;", "importanceOptions", "", "Lcom/ontime/app/logic/Importance;", "listAdapter", "Landroid/widget/ArrayAdapter;", "", "repository", "Lcom/ontime/app/activities/ActivityRepository;", "getRepository", "()Lcom/ontime/app/activities/ActivityRepository;", "repository$delegate", "Lkotlin/Lazy;", "selectedDate", "selectedEndTime", "selectedStartTime", "typeOptions", "Lcom/ontime/app/activities/ActivityType;", "clearForm", "", "hideError", "loadActivities", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveClicked", "saveActivity", "activity", "Lcom/ontime/app/activities/ActivityItem;", "setupImportanceSpinner", "setupListView", "setupPickers", "setupTypeSpinner", "showConflictDialog", "conflict", "onKeepAnyway", "Lkotlin/Function0;", "showError", "message", "showTimePicker", "onPicked", "Lkotlin/Function1;", "app_debug"})
public final class AddActivityActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ontime.app.databinding.ActivityAddActivityBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy repository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    private final java.util.Calendar calendar = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedStartTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedEndTime;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.ontime.app.logic.Importance> importanceOptions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.ontime.app.activities.ActivityType> typeOptions = null;
    private android.widget.ArrayAdapter<java.lang.String> listAdapter;
    
    public AddActivityActivity() {
        super();
    }
    
    private final com.ontime.app.activities.ActivityRepository getRepository() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupImportanceSpinner() {
    }
    
    private final void setupTypeSpinner() {
    }
    
    private final void setupListView() {
    }
    
    private final void setupPickers() {
    }
    
    private final void showTimePicker(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPicked) {
    }
    
    private final void onSaveClicked() {
    }
    
    private final void showConflictDialog(com.ontime.app.logic.Importance conflict, kotlin.jvm.functions.Function0<kotlin.Unit> onKeepAnyway) {
    }
    
    private final void saveActivity(com.ontime.app.activities.ActivityItem activity) {
    }
    
    private final void loadActivities() {
    }
    
    private final void clearForm() {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void hideError() {
    }
}