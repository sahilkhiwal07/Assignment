package com.example.assignment.data.network

import com.example.assignment.data.Result
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("jc/android_eval.json")
    suspend fun getAllData(): Response<Result>
}