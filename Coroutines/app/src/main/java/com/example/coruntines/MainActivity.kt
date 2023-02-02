package com.example.coruntines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    //Using Log Statement to check the main thread execution
    private val TAG: String = "KotlinFun"
    lateinit var counterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counter)

        //Using the log statement to check the thread is working on main thread
        Log.d(TAG,"${Thread.currentThread().name}")

    }

    fun updateCounter(view: View) {
        //Using the log statement to check the thread is working on main thread
        Log.d(TAG,"${Thread.currentThread().name}")
        counterText.text = "${counterText.text.toString().toInt() + 1}"
    }

    private fun executeLongRunning(){
        for (i in 0.. 10000000L){

        }
    }

    fun excuteTask(view: View) {
        //Creating New Thread
        thread(start = true) {
            Log.d(TAG, "${Thread.currentThread().name}")
            executeLongRunning()
        }
    }

}