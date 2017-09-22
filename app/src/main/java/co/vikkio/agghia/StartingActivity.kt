package co.vikkio.agghia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.vikkio.agghia.libs.Spicchio
import io.paperdb.Paper

class StartingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)
        Paper.init(this)

        val spicchio = Paper.book().read<Spicchio>("savedSpicchio")
        val intent: Intent?
        if (spicchio == null) {
            intent = Intent(this, MainActivity::class.java)
        } else {
            intent = Intent(this, AgghiaActivity::class.java)
            intent.putExtra("SPICCHIO", spicchio)
        }


        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}
