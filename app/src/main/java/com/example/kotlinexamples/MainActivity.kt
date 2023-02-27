package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var dataBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBinding?.btnHighOrderFunction?.setOnClickListener {

        }
    }
}