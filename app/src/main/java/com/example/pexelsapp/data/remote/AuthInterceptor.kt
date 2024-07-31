package com.example.pexelsapp.data.remote

import com.example.pexelsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", BuildConfig.PEXELS_API_KEY)
            .build()
        return chain.proceed(request)
    }
}