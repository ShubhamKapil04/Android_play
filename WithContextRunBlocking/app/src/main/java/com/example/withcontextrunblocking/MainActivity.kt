package com.example.withcontextrunblocking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "ShubhamCode"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            executeTask()
        }
    }

    private suspend fun executeTask() {
        Log.d(TAG, "BEFORE")
//        GlobalScope.launch {// NON Blocking
        withContext(Dispatchers.IO){//Blocking the thread
            delay(1000)
            Log.d(TAG, "Inside")
        }
        Log.d(TAG, "AFTER")
    }
}