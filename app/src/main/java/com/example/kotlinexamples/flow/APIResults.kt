package com.example.kotlinexamples.flow

data class APIResults<out T>(val status: Status, val data: T?, val message: String?) {

    fun <T> success(data: T?): APIResults<T>{
        return APIResults(Status.SUCCESS, data, null)
    }

    fun <T> error(message: String?): APIResults<T>{
        return APIResults(Status.ERROR, null, message)
    }

    fun <T> loading(): APIResults<T>{
        return APIResults(Status.LOADING, null, null)
    }
}

enum class Status{
    LOADING,
    ERROR,
    SUCCESS
}