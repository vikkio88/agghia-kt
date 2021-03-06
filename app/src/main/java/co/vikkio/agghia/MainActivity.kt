package co.vikkio.agghia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import co.vikkio.agghia.libs.Spicchio
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dailyHoursSb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                dailyHoursTxt.text = (progress + 1).toString()
            }
        })
        weeklyDaysSb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weeklyDaysTxt.text = (progress + 1).toString()
            }
        })

        saveBtn.setOnClickListener {
            if (!formValid()) {
                Toast.makeText(this, "Invalid Data!", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, AgghiaActivity::class.java)
                val spicchio = getSpicchio()
                intent.putExtra("SPICCHIO", spicchio)
                Thread().run {
                    Paper.book().write("savedSpicchio", spicchio)
                }
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
        }
    }

    private fun formValid(): Boolean = getSpicchio().isValid()


    private fun getSpicchio(): Spicchio {
        return Spicchio(
                (monthlyWageTxt.text.toString()).toFloatOrNull(),
                (dailyHoursTxt.text.toString()).toInt(),
                (weeklyDaysTxt.text.toString()).toInt(),
                startTimeTxt.text.toString()
        )
    }
}
