package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HighOrderFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_order_function)

        //Passing lambda as parameter
        //Passing lambda as parameter with Unit return type

        val lambda1 = { println("Hello world") }
        highOrderFunctionPassLambdaExpressionUnit(lambda1)

        //Passing lambda as parameter with Unit return type Int
        val lambda2 = { a:Int, b:Int -> a + b}
        highOrderFunctionPassLambdaExpressionType(lambda2)


        //Passing function as parameter
        //Passing lambda as parameter with Unit return type
        highOrderFunctionPassingFunctionAsParameter("This is high order function with function as parameter",::printHelloFunction)

        highOrderFunctionPassingFunctionAsParameterWithReturnVal(::sumOfTwoNumber)
    }

    private fun highOrderFunctionPassLambdaExpressionUnit(lmbd : () -> Unit){
        lmbd()
    }

    //Passing lambda as parameter with Unit return type Int
    private fun highOrderFunctionPassLambdaExpressionType(lmbd: (Int, Int) -> Int){
        val result = lmbd(5 ,5)
        println("Sum of two number is: $result")
    }

    private fun printHelloFunction(string: String){
        println(string)
    }

    private fun highOrderFunctionPassingFunctionAsParameter(string: String, lmbdFunc: (String) -> Unit){
        lmbdFunc(string)
    }

    private fun sumOfTwoNumber(a:Int, b:Int): Int{
        return a + b
    }

    private fun highOrderFunctionPassingFunctionAsParameterWithReturnVal(lmbdFunc:(Int,Int) -> Int){
        val result = lmbdFunc(5,5)
        println("Sum of two number is: $result")
    }
}