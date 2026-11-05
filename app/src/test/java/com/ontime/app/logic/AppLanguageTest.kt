package com.ontime.app.logic

import org.junit.Assert.assertEquals
import org.junit.Test

class AppLanguageTest {

    @Test
    fun `known language tags map to the right language`() {
        assertEquals(AppLanguage.ENGLISH, AppLanguage.fromTag("en"))
        assertEquals(AppLanguage.ZULU, AppLanguage.fromTag("zu"))
        assertEquals(AppLanguage.XHOSA, AppLanguage.fromTag("xh"))
    }

    @Test
    fun `tags are not case or space sensitive`() {
        assertEquals(AppLanguage.ZULU, AppLanguage.fromTag("ZU"))
        assertEquals(AppLanguage.XHOSA, AppLanguage.fromTag(" xh "))
    }

    @Test
    fun `unknown or missing tags fall back to English`() {
        assertEquals(AppLanguage.ENGLISH, AppLanguage.fromTag("fr"))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.fromTag(""))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.fromTag(null))
    }

    @Test
    fun `each language has its own tag`() {
        assertEquals(listOf("en", "zu", "xh"), AppLanguage.entries.map { it.tag })
    }
}
