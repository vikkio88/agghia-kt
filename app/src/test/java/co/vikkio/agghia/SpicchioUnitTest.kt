package co.vikkio.agghia

import co.vikkio.agghia.libs.Spicchio
import org.junit.Assert.assertFalse
import org.junit.Test


import org.junit.Assert.assertTrue
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class SpicchioUnitTest {
    @Test
    @Throws(Exception::class)
    fun spicchioCalculatesWhetherTodayIsAWorkingDayCorrectly() {
        val spicchio = Spicchio(1.0f, 1, 5, "08:00")

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        val aMonday = "2017-10-09"
        val aMondayDate = dateFormat.parse(aMonday)

        val aFriday = "2017-10-06"
        val aFridayDate = dateFormat.parse(aFriday)
        val aSaturday = "2017-10-07"
        val aSaturdayDate = dateFormat.parse(aSaturday)

        assertTrue(spicchio.isWorkingDay(aMondayDate))
        assertTrue(spicchio.isWorkingDay(aFridayDate))
        assertFalse(spicchio.isWorkingDay(aSaturdayDate))
    }
}