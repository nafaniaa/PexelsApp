package com.example.pexelsapp.data.remote

import com.example.pexelsapp.data.remote.dto.PexelsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface PexelsApi {
    @GET("v1/search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int = 15,
        @Query("page") page: Int = 1
    ): Response<PexelsResponseDto>
}