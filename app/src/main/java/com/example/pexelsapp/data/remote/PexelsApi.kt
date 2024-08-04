package com.example.pexelsapp.data.remote

import com.example.pexelsapp.data.remote.dto.PexelsResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// This file contains an interface that defines the API endpoints for the Pexels API

interface PexelsApi {
    // The searchPhotos() function defines an API endpoint for searching for photos
    @GET("v1/search")
    suspend fun searchPhotos(
        // The query parameter specifies the search query
        @Query("query") query: String,
        // The per_page parameter specifies the number of results to return per page
        // The default value is 15
        @Query("per_page") perPage: Int = 15,
        // The page parameter specifies the page of results to retrieve
        // The default value is 1
        @Query("page") page: Int = 1
    ): Response<PexelsResponseDto>
    // The function returns a Response<PexelsResponseDto> object, which contains the
    // response data from the Pexels API
}