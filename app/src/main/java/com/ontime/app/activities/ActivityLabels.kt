package com.ontime.app.activities

import android.content.Context
import androidx.annotation.StringRes
import com.ontime.app.R
import com.ontime.app.logic.Importance

/** Translated (English / isiZulu / isiXhosa) labels for the enums, via string resources. */
@StringRes
fun ActivityType.labelRes(): Int = when (this) {
    ActivityType.ASSIGNMENT -> R.string.type_assignment
    ActivityType.TEST -> R.string.type_test
    ActivityType.PRACTICAL -> R.string.type_practical
    ActivityType.STUDYING -> R.string.type_studying
    ActivityType.CLEANING -> R.string.type_cleaning
    ActivityType.SHOPPING -> R.string.type_shopping
    ActivityType.EXERCISE -> R.string.type_exercise
    ActivityType.FAMILY_ACTIVITY -> R.string.type_family_activity
    ActivityType.SOCIAL_ACTIVITY -> R.string.type_social_activity
    ActivityType.PERSONAL_APPOINTMENT -> R.string.type_personal_appointment
    ActivityType.ENTERTAINMENT -> R.string.type_entertainment
    ActivityType.OTHER -> R.string.type_other
}

@StringRes
fun Importance.labelRes(): Int = when (this) {
    Importance.HIGH -> R.string.importance_high
    Importance.MEDIUM -> R.string.importance_medium
    Importance.LOW -> R.string.importance_low
}

/** One line of text describing an activity, used by the Dashboard, Calendar and Add Activity lists. */
object ActivityFormatter {
    fun line(context: Context, item: ActivityItem, includeDate: Boolean): String {
        val datePart = if (includeDate) "${item.date}  " else ""
        val typeText = context.getString(item.type.labelRes())
        val importanceText = context.getString(item.importance.labelRes())
        val pendingText = if (item.pendingSync) {
            "  - ${context.getString(R.string.list_pending_marker)}"
        } else {
            ""
        }
        return "$datePart${item.startTime}-${item.endTime}  ${item.title} ($typeText)  [$importanceText]$pendingText"
    }
}
