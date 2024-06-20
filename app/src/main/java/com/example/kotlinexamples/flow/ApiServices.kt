package com.example.kotlinexamples.flow

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("/comments/{id}")
    suspend fun getComments(@Path("id")  id: Int)
}