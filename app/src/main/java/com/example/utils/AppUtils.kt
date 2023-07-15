package com.example.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Random
import kotlin.math.pow
import kotlin.math.roundToInt

fun String.reverse(): String {
    return this.reversed()
}


fun List<Int>.average(): Double {
    return if (isEmpty()) 0.0 else sum().toDouble() / size
}


fun Int.toRomanNumeral(): String {
    val values = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val symbols = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var remaining = this
    var result = ""

    for (i in values.indices) {
        while (remaining >= values[i]) {
            result += symbols[i]
            remaining -= values[i]
        }
    }

    return result
}

fun <T> MutableList<T>.shuffle() {
    val random = Random()
    for (i in size - 1 downTo 1) {
        val j = random.nextInt(i + 1)
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}

fun Double.round(decimals: Int): Double {
    val factor = 10.0.pow(decimals)
    return (this * factor).roundToInt() / factor
}


fun Date.format(pattern: String): String {
    val formatter = SimpleDateFormat(pattern)
    return formatter.format(this)
}
