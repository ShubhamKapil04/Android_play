package com.example.courtcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var counter_text: TextView
    private lateinit var count_textB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // For Team A
        var scoreA = 0
        counter_text = findViewById(R.id.team_a_score)
        val button_3 = findViewById<Button>(R.id.Aside_3)
        val button_2 = findViewById<Button>(R.id.Aside_2)
        val button_1 = findViewById<Button>(R.id.Afree_throw)

        // For Team B
        var scoreB = 0
        count_textB = findViewById(R.id.b_team_score)
        val b_button3 = findViewById<Button>(R.id.Bside_3)
        val b_button2 = findViewById<Button>(R.id.Bside_2)
        val b_button1 = findViewById<Button>(R.id.Bfree_throw)

        /*
        Reset Button for Both
         */
        val reset = findViewById<Button>(R.id.reset)

        button_3.setOnClickListener() {

            scoreA += 3
            counter_text.text = scoreA.toString()
            Toast.makeText(this@MainActivity, "A You Clicked on Button3", Toast.LENGTH_LONG).show()
        }
        button_2.setOnClickListener(){
            scoreA += 2
            counter_text.text = scoreA.toString()
            Toast.makeText(this@MainActivity, "A You Clicked on Button2", Toast.LENGTH_LONG).show()
        }
        button_1.setOnClickListener() {
            scoreA += 1
            counter_text.text = scoreA.toString()
            Toast.makeText(this@MainActivity, "A You Clicked on Button1", Toast.LENGTH_LONG).show()
        }


        b_button3.setOnClickListener() {

            scoreB += 3
            count_textB.text = scoreB.toString()
            Toast.makeText(this@MainActivity, "B You Clicked on Button3", Toast.LENGTH_LONG).show()
        }
        b_button2.setOnClickListener(){
            scoreB += 2
            count_textB.text = scoreB.toString()
            Toast.makeText(this@MainActivity, "B You Clicked on Button2", Toast.LENGTH_LONG).show()
        }
        b_button1.setOnClickListener() {
            scoreB += 1
            count_textB.text = scoreB.toString()
            Toast.makeText(this@MainActivity, "B You Clicked on Button1", Toast.LENGTH_LONG).show()
        }

        reset.setOnClickListener {
            scoreA = 0
            scoreB = 0
            counter_text.text = scoreA.toString()
            count_textB.text = scoreB.toString()
        }
    }
}