/*
* //This is a MainActivity class which is used to implement CoroutineScope and launch two suspend functions, task1 and task2.
* The yield() and delay() functions are used to pause the execution of the program for a certain duration of time.
* */


package com.example.suspendedfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    var TAG = "CodeWithShubham"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }
    /*
    * Calling Suspend function 1
    * */
    suspend fun task1(){
        Log.d(TAG,"Starting task 1")
        yield()
        delay(1000)
        Log.d(TAG, "Ending task 1")
    }
    /*
    Calling suspend Function 2
    * */
    suspend fun task2(){
        Log.d(TAG, "Starting task 2")
        yield()
        delay(1000)
        Log.d(TAG, "Ending task 2")
    }
}