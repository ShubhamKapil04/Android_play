package com.example.courtcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var counter_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var score = 0
        counter_text = findViewById(R.id.team_a_score)
        val button_3 = findViewById<Button>(R.id.Aside_3)
        val button_2 = findViewById<Button>(R.id.Aside_2)
        val button_1 = findViewById<Button>(R.id.Afree_throw)
        val reset = findViewById<Button>(R.id.reset)

        button_3.setOnClickListener() {

            score += 3
            counter_text.text = score.toString()
            Toast.makeText(this@MainActivity, "You Clicked on Button3", Toast.LENGTH_LONG).show()
        }
        button_2.setOnClickListener(){
            score += 2
            counter_text.text = score.toString()
            Toast.makeText(this@MainActivity, "You Clicked on Button2", Toast.LENGTH_LONG).show()
        }
        button_1.setOnClickListener() {
            score += 1
            counter_text.text = score.toString()
            Toast.makeText(this@MainActivity, "You Clicked on Button1", Toast.LENGTH_LONG).show()
        }

        reset.setOnClickListener {
            score = 0
            counter_text.text = score.toString()
        }
    }
}