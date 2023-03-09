package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CoroutinExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutin_example)
        // All coroutine code goes here
    }

    suspend fun function1(): String{
        Log.i("Launch","Inside function1")
        return "Thanks for calling function1"
    }

    suspend fun function2(): String{
        Log.i("Launch","Inside function2")
        return "Thanks for calling function2"
    }
}