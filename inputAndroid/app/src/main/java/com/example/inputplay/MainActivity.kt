@file:Suppress("SameParameterValue")

package com.example.inputplay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var counterText: TextView
    lateinit var numText: TextView
    var numberofCup : Int = 0
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        counterText = findViewById(R.id.num)
        numText = findViewById(R.id.num)
        val button = findViewById<Button>(R.id.btn)
        val inc = findViewById<Button>(R.id.increment_btn)
        val dec = findViewById<Button>(R.id.decrement_btn)



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
        }
    }

     private fun displayPrice(numberofCup: Int) {

         val price_of_Cup = 5
         val total_price = calculatePrice(numberofCup, price_of_Cup)
         displayMessage(total_price)
     }

    private fun displayMessage(total_price: Int){
        val priceText = findViewById<TextView>(R.id.order_summary_text_view)
//        priceText.text = total_price.toString()
        val message: String =  ("Name: Shubham Kapil \n" +
                                "Quantity: $numberofCup \n" +
                                "Total: $total_price$ \n" +
                                "Thank You!")

        priceText.text = message
    }

    private fun calculatePrice(numberofCup: Int, price_of_cup: Int): Int{
        return numberofCup * price_of_cup
    }


}


/*
* This method display the given quantity value on the screen
* */