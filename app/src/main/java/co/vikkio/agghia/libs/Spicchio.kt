package co.vikkio.agghia.libs

import khronos.Dates
import khronos.plus
import khronos.toDate
import khronos.toString
import java.io.Serializable
import java.util.*

data class Spicchio(val monthlyNetWage: Float?, val dailyHours: Int, val weeklyDays: Int, val startTime: String) : Serializable {
    fun isValid(): Boolean {
        if (monthlyNetWage === null || startTime === "" || !validHourFormat(startTime)) {
            return false
        }
        return true
    }

    private fun validHourFormat(startTime: String): Boolean = Regex("(0|1|2)[0-9]:[0-5][0-9]").matches(startTime)

    fun isWorkingDay(today: Date): Boolean {
        val dayOfTheWeek = getDayOfWeek(today)

        if (dayOfTheWeek == 0) {
            return false
        }

        return getDayOfWeek(today) <= this.weeklyDays
    }

    fun isWorkingtime(now: Date) {

    }

    fun getTodayStartTime(): Date = (Dates.today.toString("yyyy-MM-dd ") + this.startTime).toDate("yyyy-MM-dd HH:mm")
    fun getTodayFinishTime(): Date {
        val endTime = getTodayStartTime()
        endTime.time += this.dailyHours * 3600
        return endTime
    }

    fun getDayOfWeek(today: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = today
        return calendar.get(Calendar.DAY_OF_WEEK) - 1
    }

    private fun perWeek(): Float? = monthlyNetWage?.div(4)
    fun perDay(): Float? = perWeek()?.div(weeklyDays)
    private fun perHour(): Float? = perDay()?.div(dailyHours)
    fun perSecond(): Float? = perHour()?.div(3600)
}
