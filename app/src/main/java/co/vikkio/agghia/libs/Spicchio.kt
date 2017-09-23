package co.vikkio.agghia.libs

import java.io.Serializable

data class Spicchio(val monthlyNetWage: Float?, val dailyHours: Int, val weeklyDays: Int, val startTime: String) : Serializable {
    fun isValid(): Boolean {
        if (monthlyNetWage === null || startTime === "") {
            return false
        }
        return true
    }

    private fun perWeek(): Float? = monthlyNetWage?.div(4)
    private fun perDay(): Float? = perWeek()?.div(weeklyDays)
    private fun perHour(): Float? = perDay()?.div(dailyHours)
    fun perSecond(): Float? = perHour()?.div(3600)
}
