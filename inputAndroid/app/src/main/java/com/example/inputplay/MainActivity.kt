@file:Suppress("SameParameterValue")

package com.example.inputplay

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
    lateinit var priceText: TextView
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
            counterText.text = "$numberofCup"
            val message = displayPrice(numberofCup, hasWhippedCream, hasChocolate, nameText)
            Log.d("MainActivity",  "The Message is : $message")


            val intent = Intent(Intent.ACTION_SEND)
            //provide email address of the recipient as data
            intent.data = Uri.parse("mailto: abc@gmail.com")

            //now we will add extras with the mail
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for $nameText")
            intent.putExtra(Intent.EXTRA_TEXT, "$priceText")
            Log.d("MainActivity", "The Message is: $message")

            //set the type of mail
            intent.type = "text/plain"

            //start your intent
            startActivity(Intent.createChooser(intent, "Select your Email app"))
        }
    }

     private fun displayPrice(numberofCup: Int, hasWippedCream: Boolean, hasChocolate: Boolean, nameText: String):String {
         val message: String
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
         message = ("Name: $nameText \n" +
                               "Quantity: $numberofCup \n" +
                                "Added Whipped Cream? : $hasWippedCream \n" +
                                "Added Chocolate? : $hasChocolate \n" +
                                "Total: $total_price$ \n" +
                                "Thank You!")

         displayMessage(total_price, hasWippedCream, hasChocolate, nameText)

         return message


     }

    private fun displayMessage(total_price: Int, hasWippedCream: Boolean, hasChocolate: Boolean, nameText: String){
        priceText = findViewById<TextView>(R.id.order_summary_text_view)
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