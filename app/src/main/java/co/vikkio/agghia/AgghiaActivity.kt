package co.vikkio.agghia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import co.vikkio.agghia.libs.Spicchio
import khronos.Dates
import khronos.toDate
import khronos.toString
import kotlinx.android.synthetic.main.activity_agghia.*
import java.util.*

class AgghiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agghia)
        val spicchio = intent.getSerializableExtra("SPICCHIO") as Spicchio

        val now = Date()
        if (spicchio.isWorkingDay(now)) {
            onWorkingDay(spicchio, now)
        } else {
            onWeekend(spicchio, now)
        }


    }

    private fun onWeekend(spicchio: Spicchio, now: Date) {

    }

    private fun onWorkingDay(spicchio: Spicchio, now: Date) {
        val startingTimeToday = (Dates.today.toString("yyyy-MM-dd ") + spicchio.startTime).toDate("yyyy-MM-dd HH:mm")
        val elapsed = now.time.minus(startingTimeToday.time) / 1000
        var pay = elapsed * spicchio.perSecond()!!
        dayTxt.text = Dates.today.toString("EEEE")
        payTxt.text = "$pay £"
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                pay += spicchio.perSecond()!!
                payTxt.text = "${"%.2f".format(pay)} £"
                handler.postDelayed(this, 1000)
            }
        }, 1000)
    }
}
