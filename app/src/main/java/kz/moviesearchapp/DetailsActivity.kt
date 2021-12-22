package kz.moviesearchapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class DetailsActivity: AppCompatActivity() {

    private var discussionText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setMovieDetailsText()
        sendButtonAction()
    }

    private fun movieDetails(): List<String> {
       val poster = findViewById<ImageView>(R.id.movie_detail_poster)
        when (intent.getStringExtra("movieName")) {
            "greenMile" -> {
                title = getString(R.string.title_green_mile)
                poster.setImageResource(R.drawable.green_mile)
                return listOf("The Green Mile (1999)", "В тюрьме для смертников появляется заключенный с божественным даром. Мистическая драма по роману Стивена Кинга", "1999", "США", "драма, криминал", "«Пол Эджкомб не верил в чудеса. Пока не столкнулся с одним из них»",
                "Фрэнк Дарабонт", "Фрэнк Дарабонт, Стивен Кинг", "Фрэнк Дарабонт, Дэвид Валдес", "Томас Ньюман", "Ричард Фрэнсис-Брюс", "$60 000 000", "189 мин. / 03:09")
            }
            "shawshenk" -> {
                title = getString(R.string.title_shawshank)
                poster.setImageResource(R.drawable.shawsenk)
                return listOf("The Shawshank Redemption (1994)", "Несправедливо осужденный банкир готовит побег из тюрьмы. Тим Роббинс в выдающейся экранизации Стивена Кинга", "1994", "США", "драма", "«Страх - это кандалы. Надежда - это свобода»",
                    "Фрэнк Дарабонт", "Фрэнк Дарабонт, Стивен Кинг", "Лиз Глоцер, Дэвид В. Лестер, Ники Марвин", "Томас Ньюман", "Ричард Фрэнсис-Брюс", "$25 000 000", "142 мин. / 02:22")
            }
            "lordOfTheRings" -> {
                title = getString(R.string.title_lord_of_the_rings)
                poster.setImageResource(R.drawable.lord_of_the_rings)
                return listOf("The Lord of the Rings: The Return of the King (2003)", "Арагорн штурмует Мордор, а Фродо устал бороться с чарами кольца. Эффектный финал саги, собравший 11 «Оскаров»", "2003", "Новая Зеландия, США", "фэнтези, приключения, драма", "«There can be no triumph without loss. No victory without suffering. No freedom without sacrifice»",
                "Питер Джексон", "Фрэн Уолш, Филиппа Бойенс, Питер Джексон", "Питер Джексон, Eric Monette, Барри М. Осборн", "Говард Шор", "Джэми Селкирк", "$94 000 000", "201 мин. / 03:21")
            }
            "forrestGump" -> {
                title = getString(R.string.title_forrest_gump)
                poster.setImageResource(R.drawable.forest_gump)
                return listOf("Forrest Gump (1994)", "Полувековая история США глазами чудака из Алабамы. Абсолютная классика Роберта Земекиса с Томом Хэнксом", "1994", "США", "драма, комедия, мелодрама, история, военный", "«Мир уже никогда не будет прежним, после того как вы увидите его глазами Форреста Гампа»",
                "Роберт Земекис", "Эрик Рот, Уинстон Грум", "Венди Файнерман, Стив Старки, Стив Тиш", "Алан Сильвестри", "Артур Шмидт", "$55 000 000", "142 мин. / 02:22")
            }
            "lionKing" -> {
                title = getString(R.string.title_lion_king)
                poster.setImageResource(R.drawable.lion_king)
                return listOf("The Lion King (1994)", "Львенок Симба бросает вызов дяде-убийце. Величественный саундтрек, рисованная анимация и шекспировский размах", "1994", "США", "мультфильм, мюзикл, драма, приключения, семейный",
                "«The Circle of Life»", "Роджер Аллерс, Роб Минкофф", "Ирен Меччи, Джонатан Робертс, Линда Вулвертон", "Дон Хан, Элис Дьюи, Сара МакАртур", "Ханс Циммер", "Иван Биланкио", "$45 000 000", "88 мин. / 01:28")
            }
            else -> return listOf("nothing")
        }
    }

    private fun setMovieDetailsText() {
        findViewById<TextView>(R.id.movie_detail_title).text = movieDetails()[0]
        findViewById<TextView>(R.id.movie_detail_description).text = movieDetails()[1]
        findViewById<TextView>(R.id.movie_detail_year).text = movieDetails()[2]
        findViewById<TextView>(R.id.movie_detail_country).text = movieDetails()[3]
        findViewById<TextView>(R.id.movie_detail_genre).text = movieDetails()[4]
        findViewById<TextView>(R.id.movie_detail_tagline).text = movieDetails()[5]
        findViewById<TextView>(R.id.movie_detail_director).text = movieDetails()[6]
        findViewById<TextView>(R.id.movie_detail_scenario).text = movieDetails()[7]
        findViewById<TextView>(R.id.movie_detail_producer).text = movieDetails()[8]
        findViewById<TextView>(R.id.movie_detail_composer).text = movieDetails()[9]
        findViewById<TextView>(R.id.movie_detail_installation).text = movieDetails()[10]
        findViewById<TextView>(R.id.movie_detail_budget).text = movieDetails()[11]
        findViewById<TextView>(R.id.movie_detail_time).text = movieDetails()[12]
    }

    private fun sendDataBack() {
        val intent = Intent()
        val checkBoxValue = findViewById<CheckBox>(R.id.like_checkbox).isChecked
        intent.putExtra("etValue", discussionText)
        intent.putExtra("checkBoxValue", checkBoxValue)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun sendButtonAction() {
        findViewById<Button>(R.id.button_send_message).setOnClickListener {
            discussionText = findViewById<TextInputEditText>(R.id.movie_detail_discussion_et).text.toString()

            sendDataBack()
        }
    }
}