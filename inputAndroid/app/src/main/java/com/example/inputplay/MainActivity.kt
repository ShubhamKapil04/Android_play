package com.example.inputplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num = findViewById<TextView>(R.id.num)
        val button = findViewById<Button>(R.id.btn)


    }

    fun btn(view: View) {
        val num = findViewById<TextView>(R.id.num)
        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            num.setText("1")
        }
    }
}