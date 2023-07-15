package com.example.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utils.average
import com.example.utils.format
import com.example.utils.reverse
import com.example.utils.round
import com.example.utils.shuffle

import com.example.utils.toRomanNumeral
import java.util.Date

class ExtensionFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_function)

        val str = "Hello, World!"
        val reversedStr = str.reverse()
        println(reversedStr) // Output: "!dlroW ,olleH"

        var numbers = listOf(1, 2, 3, 4, 5)
        val average = numbers.average()
        println(average) // Output: 3.0

        val number = 42
        val romanNumeral = number.toRomanNumeral()
        println(romanNumeral) // Output: "XLII"

        numbers = mutableListOf(1, 2, 3, 4, 5)
        numbers.shuffle()
        println(numbers) // Output: Randomly shuffled list of numbers

        val number1 = 3.1415926535
        var roundedNumber = number1.round(2)
        println(roundedNumber) // Output: 3.14

        val currentDate = Date()
        val formattedDate = currentDate.format("yyyy-MM-dd")
        println(formattedDate) // Output: Current date in "yyyy-MM-dd" format
    }

}