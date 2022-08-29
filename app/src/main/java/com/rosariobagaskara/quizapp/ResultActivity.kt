package com.rosariobagaskara.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var nameTextView: TextView? = null
        var scoreTextView: TextView? = null
        var buttonFinish: Button? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        nameTextView = findViewById(R.id.nameTextView)
        scoreTextView = findViewById(R.id.scoreTextView)
        buttonFinish = findViewById(R.id.btnFinish)
        val valueIntent = getIntent()
        var name = valueIntent.getStringExtra("inputName")
        var correctAnswer = valueIntent.getStringExtra("correctAnswer")

        nameTextView.text = name.toString()
        scoreTextView.text = "Your Score is $correctAnswer out of 10!"

        buttonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}