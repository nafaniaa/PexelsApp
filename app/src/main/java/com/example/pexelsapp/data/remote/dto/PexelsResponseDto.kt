package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.SerializedName



data class PexelsResponseDto(
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("photos")
    val photos: List<PhotoDto>
)
