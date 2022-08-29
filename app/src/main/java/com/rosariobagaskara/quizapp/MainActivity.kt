package com.rosariobagaskara.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.buttonStartId)
        val inputName: EditText = findViewById(R.id.inputText)
        btnStart.setOnClickListener {
            if(inputName.text.isEmpty()){
                Toast.makeText(this, "Please Enter Your Name!", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                val valueName = inputName.text.toString()
                intent.putExtra("inputName",valueName)
                startActivity(intent)
                finish()
            }
        }
    }
}