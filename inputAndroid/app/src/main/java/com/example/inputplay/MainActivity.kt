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
        val button = findViewById<Button>(R.id.btn)
        var numberofCup : Int = 0
        button.setOnClickListener {
            numberofCup++
            counterText.text = "${numberofCup}"
            displayPrice(numberofCup)
//            text = "${counterText.text.toString().toInt()}"
        }
    }

     private fun displayPrice(numberofCup: Int) {
         //This will store the view for price
         val priceText = findViewById<TextView>(R.id.price_text_view)
         val price_of_Cup = 10
//         priceText = numberofCup + price_of_Cup
         priceText.setText("${numberofCup * price_of_Cup}")
     }
}


/*
* This method display the given quantity value on the screen
* */