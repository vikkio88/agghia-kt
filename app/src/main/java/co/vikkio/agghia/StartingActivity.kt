package co.vikkio.agghia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class StartingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)
        val stuff = false
        val intent: Intent?

        intent = if (stuff) {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, AgghiaActivity::class.java)
        }

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}
