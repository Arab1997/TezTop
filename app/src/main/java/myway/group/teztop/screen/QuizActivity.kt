package myway.group.teztop.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_quiz.imageback
import kotlinx.android.synthetic.main.activity_sciences.*
import myway.group.teztop.R
import myway.group.teztop.models.ScienceModel

class QuizActivity : AppCompatActivity() {
    lateinit var science: ScienceModel
    var index = 0
    var correctCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        imageback.setOnClickListener{
            finish()
        }
        science = intent.getSerializableExtra("extra") as ScienceModel

        btnA.setOnClickListener {
            if (science.quizList[index].correctAnswer == "A"){
                correctCount++
            }

                index++
            setQuiz()
        }

        btnB.setOnClickListener {
            if (science.quizList[index].correctAnswer == "B"){
                correctCount++
            }

            index++
            setQuiz()
        }

        btnC.setOnClickListener {
            if (science.quizList[index].correctAnswer == "C"){
                correctCount++
            }

            index++
            setQuiz()
        }

        btnD.setOnClickListener {
            if (science.quizList[index].correctAnswer == "D"){
                correctCount++
            }

            index++
            setQuiz()
        }

        setQuiz()
    }

    fun setQuiz() {
        if (index < science.quizList.count()) {  //index countan kichkina bolsa ishlavursin
            val quiz = science.quizList[index]
            tvQuiz.text = quiz.title
            if (quiz.image != null) {   // image teng bomasa nullga
                imageQuiz.visibility = View.VISIBLE
                imageQuiz.setImageResource(quiz.image)
            } else {
                imageQuiz.visibility = View.GONE
            }
            btnA.text = quiz.answerA
            btnB.text = quiz.answerB
            btnC.text = quiz.answerC
            btnD.text = quiz.answerD
        }else{
            Toast.makeText(this, "Siz ${science.quizList.count()} ta savoldan ${correctCount} ta siga to'g'ri javob berdingiz!", Toast.LENGTH_LONG).show()
        }
    }
    }
