package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinexamples.databinding.ActivityCoroutinExampleBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinExampleActivity : AppCompatActivity() {

    private var binding: ActivityCoroutinExampleBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinExampleBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnCallCoRoutine?.setOnClickListener {
            coRoutineUsingLaunch()
            coRoutineUsingAsync()
        }
    }

    private fun coRoutineUsingLaunch(){
        val desc = StringBuilder()
        desc.append("Main function(out of coroutine) Started \n")
        GlobalScope.launch {
            val funAResult = printFunctionsALaunch(desc)
            val funBResult = printFunctionsBLaunch(desc)
            // below code will run one by once line as is in launch
            desc.append(funAResult)
            printDescA(desc)
            desc.append(funBResult)
            printDescA(desc)
            desc.append("\nFunc A and Call finished Concat:$funAResult$funBResult")
            printDescA(desc)
        }
        desc.append("\n Main function(out of coroutine) End")
    }

    private fun coRoutineUsingAsync(){
        val desc = StringBuilder()
        desc.append("Main function(out of coroutine) Started \n")
        GlobalScope.launch {
            val funAResult = async {printFunctionsAAsync(desc)}
            val funBResult = async { printFunctionsBAsync(desc) }
            // below code will run one by once line as is in launch
            desc.append(funAResult.await())
            printDescB(desc)
            desc.append(funBResult.await())
            printDescB(desc)
            desc.append("\nFunc A and Call finished Concat:${funAResult.await()}${funBResult.await()}")
            printDescB(desc)
        }
        desc.append("\n Main function(out of coroutine) End")
    }

    private fun printDescA(desc: StringBuilder) {
        runOnUiThread {
            binding?.tvLaunchOp?.text = desc
        }
    }

    private fun printDescB(desc: StringBuilder) {
        runOnUiThread {
            binding?.tvAsyncOp?.text = desc
        }
    }

    private suspend fun printFunctionsALaunch(desc: StringBuilder): String {
        desc.append("\n Function A started")
        printDescA(desc)
        delay(3000)
        desc.append("\n Function A End - after delay")
        printDescA(desc)
        return ("\n Function A finished")
    }

    private suspend fun printFunctionsBLaunch(desc: StringBuilder): String {
        desc.append("\n Function B started")
        printDescA(desc)
        delay(100)
        desc.append("\n Function B End - after delay") // in output you will notice that this function called after when its called from async
        printDescA(desc)
        return "\n Function b finished"
    }

    private suspend fun printFunctionsAAsync(desc: StringBuilder): String {
        desc.append("\n Function A started")
        printDescA(desc)
        delay(3000)
        desc.append("\n Function A End - after delay")
        printDescA(desc)
        return ("\n Function A finished")
    }

    private suspend fun printFunctionsBAsync(desc: StringBuilder): String {
        desc.append("\n Function B started")
        printDescA(desc)
        delay(100)
        desc.append("\n Function B End - after delay") // in output you will notice that this function called first when its called from async
        printDescA(desc)
        return "\n Function b finished"
    }
}