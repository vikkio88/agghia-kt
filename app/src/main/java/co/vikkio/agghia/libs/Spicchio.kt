package co.vikkio.agghia.libs

data class Spicchio(val monthlyNetWage: Float?, val dailyHours: Int?, val weeklyDays: Int?, val startTime: String) {
    fun isValid(): Boolean {
        if (monthlyNetWage === null || dailyHours === null || weeklyDays === null || startTime === "") {
            return false
        }

        return true
    }
}
