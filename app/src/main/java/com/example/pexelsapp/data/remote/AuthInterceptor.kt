package com.example.pexelsapp.data.remote

import com.example.pexelsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

// This file contains an implementation of the Interceptor interface for adding an authorization header to the HTTP request

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", BuildConfig.PEXELS_API_KEY)
            .build()
        return chain.proceed(request)
    }
}