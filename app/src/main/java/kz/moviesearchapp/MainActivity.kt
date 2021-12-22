package kz.moviesearchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.title_main)
        toDetailsActivityAction()
        shareButtonAction()
    }

    private fun toDetailsActivityAction() {
        findViewById<Button>(R.id.button_green_mile_details).setOnClickListener {
            intentWithArgument("greenMile")
        }
        findViewById<Button>(R.id.button_shawshenk_details).setOnClickListener {
            intentWithArgument("shawshenk")
        }
        findViewById<Button>(R.id.button_lord_of_the_rings_details).setOnClickListener {
            intentWithArgument("lordOfTheRings")
        }
        findViewById<Button>(R.id.button_forrest_gump_details).setOnClickListener {
            intentWithArgument("forrestGump")
        }
        findViewById<Button>(R.id.button_lion_king_details).setOnClickListener {
            intentWithArgument("lionKing")
        }
    }

    private fun shareButtonAction() {
        findViewById<ImageButton>(R.id.share_button_green_mile).setOnClickListener {
            shareButtonIntent(getString(R.string.title_green_mile))
        }
        findViewById<ImageButton>(R.id.share_button_shawshenk).setOnClickListener {
            shareButtonIntent(getString(R.string.title_shawshank))
        }
        findViewById<ImageButton>(R.id.share_button_lord_of_the_rings).setOnClickListener {
            shareButtonIntent(getString(R.string.title_lord_of_the_rings))
        }
        findViewById<ImageButton>(R.id.share_button_forrest_gump).setOnClickListener {
            shareButtonIntent(getString(R.string.title_forrest_gump))
        }
        findViewById<ImageButton>(R.id.share_button_lion_king).setOnClickListener {
            shareButtonIntent(getString(R.string.title_lion_king))
        }
    }

    private fun intentWithArgument(movieName: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movieName", movieName)
        startActivityForResult(intent,1)
    }

    private fun shareButtonIntent(movieName: String) {
        val intent= Intent()
        intent.action=Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "Хей, срочно посмотри фильм $movieName! Тебе точно зайдет!")
        intent.type="text/plain"
        startActivity(Intent.createChooser(intent,"Share To:"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val getTextFromDetails = data?.getStringExtra("etValue")
                val getCheckboxValue = data?.getBooleanExtra("checkBoxValue", false)
                println("Text from discussion is: $getTextFromDetails, do you like it: $getCheckboxValue")
            }
        }
    }
}