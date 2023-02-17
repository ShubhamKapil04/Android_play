package com.example.inputplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var counterText: TextView
    lateinit var numText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.num)
        numText = findViewById(R.id.num)
        val button = findViewById<Button>(R.id.btn)
        val inc = findViewById<Button>(R.id.increment_btn)
        val dec = findViewById<Button>(R.id.decrement_btn)
        var numberofCup : Int = 0
        inc.setOnClickListener() {
            numberofCup++
            numText.text = "${numberofCup}"

        }
        dec.setOnClickListener() {
            numberofCup--
            numText.text = "${numberofCup}"
        }
        button.setOnClickListener() {
            counterText.text = "${numberofCup}"
            displayPrice(numberofCup)
//            text = "${counterText.text.toString().toInt()}"
        }
    }

     private fun displayPrice(numberofCup: Int) {
         //This will store the view for price
         val priceText = findViewById<TextView>(R.id.price_text_view)
         val price_of_Cup = 5
//         priceText = numberofCup + price_of_Cup
         priceText.setText("Total : $${numberofCup * price_of_Cup}")
         displayMessage()
     }

    private fun displayMessage(){
        val message: String = "ThankYou"
        var messageD = findViewById<TextView>(R.id.message)
        messageD.setText(message)
    }


}


/*
* This method display the given quantity value on the screen
* */