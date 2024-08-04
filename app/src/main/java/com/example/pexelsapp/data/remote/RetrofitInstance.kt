package com.example.pexelsapp.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This file contains an object that creates and provides access to the Pexels API instance

object RetrofitInstance {
    // The base URL for the Pexels API
    private const val BASE_URL = "https://api.pexels.com/"

    // Create an OkHttpClient instance with the AuthInterceptor added
    // The AuthInterceptor is responsible for adding the API key to the request headers
    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .build()

    // Create a lazy-initialized PexelsApi instance using Retrofit
    val api: PexelsApi by lazy {
        Retrofit.Builder()
            // Set the base URL for the API
            .baseUrl(BASE_URL)
            // Use the OkHttpClient instance with the AuthInterceptor
            .client(client)
            // Use Gson as the converter factory for parsing the API response
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            // Create the PexelsApi instance
            .create(PexelsApi::class.java)
    }
}