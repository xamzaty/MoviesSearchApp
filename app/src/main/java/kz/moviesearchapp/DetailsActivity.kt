package kz.moviesearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        movie()
    }

    private fun movie() {
        when (intent.getStringExtra("movieName")) {
            "greenMile" -> {
                title = getString(R.string.title_green_mile)
            }
            "shawshenk" -> {
                title = getString(R.string.title_shawshank)
            }
            "lordOfTheRings" -> {
                title = getString(R.string.title_lord_of_the_rings)
            }
            "forestGump" -> {
                title = getString(R.string.title_forest_gump)
            }
            "lionKing" -> {
                title = getString(R.string.title_lion_king)
            }
        }
    }
}