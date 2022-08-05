package com.rosariobagaskara.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionsList =  Constants.getQuestion()

        Log.i("The questionsList size is", "${questionsList.size}")
    }
}