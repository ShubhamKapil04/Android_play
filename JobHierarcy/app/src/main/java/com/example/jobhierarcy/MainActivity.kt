package com.example.jobhierarcy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "SHUBHAMCODE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.Main){
            execute()
        }
    }

    suspend private fun execute() {

        val parentJob = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1 .. 1000){
                if(isActive) {
                    executingLongRunningTask()
                    Log.d(TAG, i.toString())
                }
            }
        }
        delay(100)
        Log.d(TAG, "Cancelling Job")
        parentJob.cancel()
        parentJob.join()
        Log.d(TAG,"Parent Complete")
//        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent job Started")
//
//            // Child job inherit the parent context if not pass in child
//            val childJob = launch(Dispatchers.IO) {
//                try {
//                    Log.d(TAG,"Child job Started")
//                    delay(5000)
//                    Log.d(TAG, "Chiled job Ended")
//                } catch (e: CancellationException) {
//                    Log.d(TAG, "Child job Canceled")
//                }
//            }
//            delay(3000)
//            childJob.cancel()
//            Log.d(TAG, "Parent job Ended")
//        }
////        delay(1000)
////        parentJob.cancel()// Suspending the parent job
//
//        parentJob.join()
//        Log.d(TAG, "ParentJob Completed")
    }

    private fun executingLongRunningTask(){
        for(i in 1..1000){
        }
    }

}