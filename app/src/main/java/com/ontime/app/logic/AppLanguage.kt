package com.ontime.app.logic

/** The three languages the app supports. English is the default. */
enum class AppLanguage(val tag: String) {
    ENGLISH("en"),
    ZULU("zu"),
    XHOSA("xh");

    companion object {
        /** Unknown or missing tags fall back to English instead of crashing. */
        fun fromTag(tag: String?): AppLanguage =
            entries.firstOrNull { it.tag.equals(tag?.trim(), ignoreCase = true) } ?: ENGLISH
    }
}
