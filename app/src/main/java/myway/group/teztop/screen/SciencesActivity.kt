package myway.group.teztop.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import myway.group.teztop.R
import myway.group.teztop.models.ScienceModel
import myway.group.teztop.view.SciencesAdapter
import kotlinx.android.synthetic.main.activity_sciences.*
import myway.group.teztop.models.QuizModel
import myway.group.teztop.view.SciencesAdapterCallback

class SciencesActivity : AppCompatActivity() {
    val sciences= listOf(
        ScienceModel( "Matematik", listOf(
            QuizModel("2 ning kvadrati nechi?", R.drawable.main, "2", "4","8" ,"16","B" ),
            QuizModel("3 ning kvadrati nechi?", R.drawable.main, "2", "4","9" ,"16","C" ),
            QuizModel("4 ning kvadrati nechi?", R.drawable.main, "12", "14","8" ,"16","D" ),
            QuizModel("5 ning kvadrati nechi?", R.drawable.main, "22", "4","8" ,"25","D" ),
            QuizModel("6 ning kvadrati nechi?", null, "36", "4","8" ,"16","A" ),
            QuizModel("7 ning kvadrati nechi?", null, "42", "35","49" ,"16","C" )
        )),
        ScienceModel( "Ona tili", emptyList()),
        ScienceModel( "Fizika", emptyList()),
        ScienceModel( "Adabiyot", emptyList()),
        ScienceModel( "Biologiya", emptyList()),
        ScienceModel( "Ingliz tili", emptyList())
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sciences)

        imageback.setOnClickListener{
            finish()
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SciencesAdapter(sciences, object: SciencesAdapterCallback{
            override fun onClick(item: ScienceModel) {
                val intent  = Intent(this@SciencesActivity, QuizActivity::class.java)
                intent.putExtra("extra", item)
                startActivity(intent)
            }
        })


    }
}