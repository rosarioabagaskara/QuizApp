package com.rosariobagaskara.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var questionList : ArrayList<Question>? = null
    private var selectedOptions: Int? = null

    private var questionTextview: TextView? = null
    private var flagImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var progressTextview: TextView? = null
    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null
    private var buttonSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        questionTextview = findViewById(R.id.questionTextView)
        flagImage = findViewById(R.id.imageView)
        progressBar = findViewById(R.id.progressBar)
        progressTextview = findViewById(R.id.progressTextview)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        buttonSubmit = findViewById(R.id.button)
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        questionList = Constants.getQuestion()
        getQuestion()
    }

    private fun getQuestion() {
        var question = questionList!![currentPosition - 1]
        progressBar?.progress = currentPosition
        progressTextview?.text = "$currentPosition/${progressBar?.max}"
        questionTextview?.text = question.question
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
        flagImage?.setImageResource(question.image)
        if (progressBar?.progress == progressBar?.max){
            buttonSubmit?.text = "Finish"
        }
    }

    fun defaultOptions(){
        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }
        for(option in options){
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.text_background
            )
        }
    }

    fun selectedOption(textView: TextView, currentOptions: Int){
        defaultOptions()
        selectedOptions = currentOptions

        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.text_background_selected
        )
    }

    override fun onClick(view: View) {
        when(view?.id){
            R.id.option1 -> {
                option1?.let {
                    selectedOption(it, 0)
                }
            }
            R.id.option2 -> {
                option2?.let {
                    selectedOption(it, 1)
                }
            }
            R.id.option3 -> {
                option3?.let {
                    selectedOption(it, 2)
                }
            }
            R.id.option4 -> {
                option4?.let {
                    selectedOption(it, 3)
                }
            }
        }
    }
}