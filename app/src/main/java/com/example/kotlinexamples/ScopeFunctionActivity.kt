package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ScopeFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_order_function)
        letScopeFunctions()
    }

    /**
     * This function represents use case of let scope functions
     * Context object : it
     * Return value : lambda
     */
    private fun letScopeFunctions() {
        // nullable string value
        var message: String? = null

        message.let {
            print(it)
        }
        message = "Now this line will be printed"
        message.let {
            print(it)
        }
    }
}