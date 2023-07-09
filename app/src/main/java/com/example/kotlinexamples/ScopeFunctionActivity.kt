package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ScopeFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_function)
        letScopeFunctions()
        applyScopeFunctions()
        runScopeFunctions()
        withScopeFunctions()

    }
    /**
     * This function represents use case of with scope functions
     * with used for calling function on context object without providing lambda
     * Context object : this
     * Return value : context object
     */
    private fun withScopeFunctions() {
        val emp = Employee(empId = 1).apply {
            empName = "John"
        }
        with(emp){
            Log.i("ScopeWith",emp.empName)
        }
    }

    /**
     * This function represents use case of run scope functions
     * Context object : this
     * Return value : lambda
     */
    private fun runScopeFunctions() {
        var emp: Employee?= null

        emp?.run {
            Log.i("ScopeWith",this.empName)
        }
        emp = Employee(empId = 1).apply {
            empName = "John"
        }
        emp.run {
            Log.i("ScopeWith",this.empName)

        }
    }

    /**
     * This function represents use case of apply scope functions
     * Context object : this
     * Return value : context object
     */
    private fun applyScopeFunctions() {
        val emp = Employee(empId = 1).apply {
            empName = "John"
        }
        Log.i("ScopeApply",emp.empId.toString().plus(emp.empName))
    }

    /**
     * This function represents use case of let scope functions
     * Context object : it
     * Return value : lambda
     */
    private fun letScopeFunctions() {
        // nullable string value
        var message: String? = null

        message?.let {
            //below statement will not execute as var is null
            Log.i("ScopeLet",it)
        }
        message = "Now this line will be printed"
        message.let {
            //below statement will execute as var is null
            Log.i("ScopeLet",it)
        }
    }

    data class Employee(val empId: Int){
        lateinit var empName: String
    }
}