package kz.moviesearchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.title_main)

        findViewById<Button>(R.id.button_green_mile_details).setOnClickListener {
            intentWithArgument("greenMile")
        }
        findViewById<Button>(R.id.button_shawshenk_details).setOnClickListener {
            intentWithArgument("shawshenk")
        }
        findViewById<Button>(R.id.button_lord_of_the_rings_details).setOnClickListener {
            intentWithArgument("lordOfTheRings")
        }
        findViewById<Button>(R.id.button_forest_gump_details).setOnClickListener {
            intentWithArgument("forestGump")
        }
        findViewById<Button>(R.id.button_lion_king_details).setOnClickListener {
            intentWithArgument("lionKing")
        }
    }

    private fun intentWithArgument(movieName: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movieName", movieName)
        startActivity(intent)
    }
}