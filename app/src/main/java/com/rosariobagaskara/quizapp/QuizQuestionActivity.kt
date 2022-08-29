package com.rosariobagaskara.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var currentPosition = 1
    private var correctAnswer = 10
    private var inputName: String = ""
    private var questionList : ArrayList<Question>? = null
    private var selectedOptions: Int = 0
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
        buttonSubmit = findViewById(R.id.button_sbm)
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)
        questionList = Constants.getQuestion()
        getQuestion()
    }

    private fun getQuestion() {
        defaultOptions()
        var question = questionList!![currentPosition - 1]
        progressBar?.progress = currentPosition
        progressTextview?.text = "$currentPosition/${progressBar?.max}"
        questionTextview?.text = question.question
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
        flagImage?.setImageResource(question.image)
        buttonSubmit?.text = "Submit"
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
                    selectedOption(it, 1)
                }
            }
            R.id.option2 -> {
                option2?.let {
                    selectedOption(it, 2)
                }
            }
            R.id.option3 -> {
                option3?.let {
                    selectedOption(it, 3)
                }
            }
            R.id.option4 -> {
                option4?.let {
                    selectedOption(it, 4)
                }
            }

            R.id.button_sbm ->{
                if(selectedOptions == 0 && buttonSubmit?.text == "Go to next question" || buttonSubmit?.text == "Finish"){
                    currentPosition++
                    when{
                        currentPosition <= questionList!!.size ->{
                            getQuestion()
                        }
                        else -> {
                            Toast.makeText(this, "You have completed the quiz!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            val valueIntent = getIntent()
                            inputName = valueIntent.getStringExtra("inputName").toString()
                            intent.putExtra("correctAnswer", correctAnswer.toString())
                            intent.putExtra("inputName", inputName)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = questionList?.get(currentPosition - 1)
                    if(question!!.correctAnswer != selectedOptions){
                        answerView(selectedOptions, R.drawable.false_text_background)
                        correctAnswer--
                    }
                    answerView(question.correctAnswer, R.drawable.correct_text_background)

                    if(currentPosition == questionList?.size){
                        buttonSubmit?.text = "Finish"
                    }else{
                        buttonSubmit?.text = "Go to next question"
                    }
                    selectedOptions = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                option1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                option2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                option3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                option4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}