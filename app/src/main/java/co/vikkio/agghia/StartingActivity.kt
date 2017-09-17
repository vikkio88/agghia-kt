package co.vikkio.agghia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class StartingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)
        val stuff = true

        if (stuff) {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
