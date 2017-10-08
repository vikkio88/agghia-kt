package co.vikkio.agghia

import co.vikkio.agghia.libs.Spicchio
import org.junit.Assert.assertFalse
import org.junit.Test


import org.junit.Assert.assertTrue
import java.text.SimpleDateFormat
import java.util.*

class SpicchioUnitTest {
    @Test
    @Throws(Exception::class)
    fun calculatesWhetherTodayIsAWorkingDayCorrectly() {
        val spicchio = Spicchio(1.0f, 1, 5, "08:00")

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        val aMonday = "2017-10-09"
        val aMondayDate = dateFormat.parse(aMonday)

        val aFriday = "2017-10-06"
        val aFridayDate = dateFormat.parse(aFriday)

        val aSaturday = "2017-10-07"
        val aSaturdayDate = dateFormat.parse(aSaturday)

        val aSunday = "2017-10-08"
        val aSundayDate = dateFormat.parse(aSunday)

        assertTrue(spicchio.isWorkingDay(aMondayDate))
        assertTrue(spicchio.isWorkingDay(aFridayDate))
        assertFalse(spicchio.isWorkingDay(aSaturdayDate))
        assertFalse(spicchio.isWorkingDay(aSundayDate))
    }

    @Test
    @Throws(Exception::class)
    fun itValidateCorrectlyWhetherATimeIsInTheCorrectFormat() {
        val spicchioWithCorrectHour = Spicchio(1.0f, 1, 5, "08:00")
        val spicchioWithWrongHour = Spicchio(1.0f, 1, 5, "ciao:00")

        assertTrue(spicchioWithCorrectHour.isValid())
        assertFalse(spicchioWithWrongHour.isValid())
    }


}