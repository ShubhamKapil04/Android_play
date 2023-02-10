package com.example.corutinesbuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val TAG : String = "Shubham"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    private suspend fun printFollowers() {
//        var fbFollowers = 0
//        var instaFollowers = 0
        val fbFollowers = CoroutineScope(Dispatchers.IO).async {
            getFbfollowes()
        }

        val instaFollowers = CoroutineScope(Dispatchers.IO).async{
            getInstafollowers()
        }

//        job1.join() // This use when we want response from the api call
//        // And want to suspend the next line to execute before call return
//        job2.join()
//        Log.d(TAG, "Fb --> ${fbFollowers.toString()} Insta --> ${instaFollowers.toString()}")

        Log.d(TAG, "Fb -->  ${fbFollowers.await()} Insta -->  ${instaFollowers.await()}")
    }

    private suspend fun getInstafollowers() : Int{
        delay(1000)
        return 128
    }

    private suspend fun getFbfollowes(): Int {
        delay(1000)
        return 54
    }
}