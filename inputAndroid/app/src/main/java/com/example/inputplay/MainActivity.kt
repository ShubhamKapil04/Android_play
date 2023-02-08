package com.example.inputplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var counterText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.num)
        displayPrice(2 * 5)
    }

    fun btn(view: View) {
        counterText.text = "${counterText.text.toString().toInt() + 1 * 2}"
    }
    /*
* This method display the given quantity value on the screen
* */
    fun displayPrice(int: Int){
        val priceTextView = findViewById<TextView>(R.id.price_text_view)
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(int))
    }
}