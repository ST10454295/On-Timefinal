package com.ontime.app.activities

/**
 * Activity categories, straight from the planning document's list under
 * 3.2 Adding activities.
 */
enum class ActivityType {
    ASSIGNMENT,
    TEST,
    PRACTICAL,
    STUDYING,
    CLEANING,
    SHOPPING,
    EXERCISE,
    FAMILY_ACTIVITY,
    SOCIAL_ACTIVITY,
    PERSONAL_APPOINTMENT,
    ENTERTAINMENT,
    OTHER;

    fun displayLabel(): String = name
        .lowercase()
        .split("_")
        .joinToString(" ") { it.replaceFirstChar(Char::titlecase) }
}
