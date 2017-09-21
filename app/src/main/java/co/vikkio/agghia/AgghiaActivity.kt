package co.vikkio.agghia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import khronos.Dates
import khronos.toString
import kotlinx.android.synthetic.main.activity_agghia.*

class AgghiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var pay = 10
        setContentView(R.layout.activity_agghia)
        dayTxt.text = Dates.today.toString("EEEE")
        payTxt.text = "$pay £"

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                pay += 1
                payTxt.text = "$pay £"
                handler.postDelayed(this, 1000)
            }
        }, 1000)

    }
}
