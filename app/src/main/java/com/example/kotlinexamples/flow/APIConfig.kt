package com.example.kotlinexamples.flow

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIConfig {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    // create retrofit service
    fun ApiService(): ApiServices =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiServices::class.java)
}