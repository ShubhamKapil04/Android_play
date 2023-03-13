@file:Suppress("SameParameterValue")

package com.example.inputplay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var counterText: TextView
    lateinit var numText: TextView
    var numberofCup : Int = 2
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        counterText = findViewById(R.id.num)
        numText = findViewById(R.id.num)
        val button = findViewById<Button>(R.id.btn)
        val inc = findViewById<Button>(R.id.increment_btn)
        val dec = findViewById<Button>(R.id.decrement_btn)
        val  whippedCreamCheckBox = findViewById<CheckBox>(R.id.Whipped_cream)
        val chocholateCheckBox = findViewById<CheckBox>(R.id.Chocolate)
        val name_text_input = findViewById<EditText>(R.id.name_text_input)

        //CheckBox
//        val hasWhippedCream = findViewById<CheckBox>(R.id.Whipped_cream)
//            .setOnCheckedChangeListener { _ , isChecked ->
//                Log.d("CheckBox", "Whipped Cream is : $isChecked")
//            }




        inc.setOnClickListener() {
            if(numberofCup > 100){
                Toast.makeText(this, "You can't have this much of Coffee Cup", Toast.LENGTH_SHORT).show()
            }else{
                numberofCup++
                numText.text = "$numberofCup"

            }
        }
        dec.setOnClickListener() {
            numberofCup--
            if(numberofCup <= 0){
                Toast.makeText(this, "You can't have less then 1 Coffee Cup", Toast.LENGTH_SHORT).show()
            }else{
                numText.text = "$numberofCup"
            }
        }
        button.setOnClickListener() {
            //Checked Box
            val hasWhippedCream = whippedCreamCheckBox.isChecked
            val hasChocolate = chocholateCheckBox.isChecked
            //Name
            val nameText: String = name_text_input.text.toString()
            Log.d("MainActivity","The Name is : $nameText")
            counterText.text = "$numberofCup"
            displayPrice(numberofCup, hasWhippedCream, hasChocolate, nameText)
        }
    }

     private fun displayPrice(numberofCup: Int, hasWippedCream: Boolean, hasChocolate: Boolean, nameText: String) {

         val price_of_Cup = 5
         val total_price: Int
         val whippedCreamCost: Int
         val chocolateCost: Int
         if(hasWippedCream && hasChocolate) {
             whippedCreamCost = numberofCup
             chocolateCost = numberofCup * 2
             total_price = calculatePrice(numberofCup, price_of_Cup, whippedCreamCost, chocolateCost)
         }else if(hasWippedCream){
             whippedCreamCost = numberofCup
             total_price = calculatePrice(numberofCup, price_of_Cup, whippedCreamCost, 0)
         }else if(hasChocolate){
             chocolateCost = numberofCup * 2
             total_price = calculatePrice(numberofCup, price_of_Cup, 0, chocolateCost)
         }else{
             total_price = calculatePrice(numberofCup, price_of_Cup, 0, 0)
         }
         displayMessage(total_price, hasWippedCream, hasChocolate, nameText)
     }

    private fun displayMessage(total_price: Int, hasWippedCream: Boolean, hasChocolate: Boolean, nameText: String){
        val priceText = findViewById<TextView>(R.id.order_summary_text_view)
//        priceText.text = total_price.toString()
        val message: String =  ("Name: $nameText \n" +
                                "Quantity: $numberofCup \n" +
                                "Added Whipped Cream? : $hasWippedCream \n" +
                                "Added Chocolate? : $hasChocolate \n" +
                                "Total: $total_price$ \n" +
                                "Thank You!")

        priceText.text = message
    }

    private fun calculatePrice(numberofCup: Int, price_of_cup: Int, wippedCreamCost: Int, chocolateCost: Int): Int{
        return numberofCup * price_of_cup + wippedCreamCost + chocolateCost
    }

}


/*
* This method display the given quantity value on the screen
* */