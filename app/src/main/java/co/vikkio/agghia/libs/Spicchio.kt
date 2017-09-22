package co.vikkio.agghia.libs

import java.io.Serializable

data class Spicchio(val monthlyNetWage: Float?, val dailyHours: Int?, val weeklyDays: Int?, val startTime: String) : Serializable {
    fun isValid(): Boolean {
        if (monthlyNetWage === null || dailyHours === null || weeklyDays === null || startTime === "") {
            return false
        }

        return true
    }
}
