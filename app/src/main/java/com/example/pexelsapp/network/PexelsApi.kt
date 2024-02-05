package com.example.pexelsapp.network

import com.example.pexelsapp.data.PexelsPhoto
import com.example.pexelsapp.data.PhotosRepository
import retrofit2.http.GET
import retrofit2.http.Query

interface PexelsApi {

    @GET("search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1
    ):  PexelsResponse

    //Запрос на получение текущих фотографий
    @GET("curated")
    suspend fun getCuratedPhotos(
        @Query("per_page") perPage: Int=30,
        @Query("page") page :Int = 1
    ) : PexelsResponse
}