package com.example.kotlinexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexamples.databinding.ActivityMainBinding
import com.example.kotlinexamples.flow.FlowExampleActivity

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        binding?.btnHighOrderFunction?.setOnClickListener {
            startActivity(Intent(this@MainActivity,HighOrderFunctionActivity::class.java))
        }

        binding?.btnCoRoutine?.setOnClickListener {
            startActivity(Intent(this@MainActivity,CoroutinExampleActivity::class.java))
        }

        binding?.btnScopeFunction?.setOnClickListener {
            startActivity(Intent(this@MainActivity,ScopeFunctionActivity::class.java))
        }

        binding?.btnExtensionFunction?.setOnClickListener {
            startActivity(Intent(this@MainActivity,ExtensionFunctionActivity::class.java))
        }

        binding?.btnFlowExample?.setOnClickListener {
            startActivity(Intent(this@MainActivity,FlowExampleActivity::class.java))
        }
    }
}