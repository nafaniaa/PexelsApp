package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


// This file contains a data class that represents the response from the Pexels API
data class PexelsResponseDto(
    @SerializedName("total_results") @Expose
    val total_results: Int,
    @SerializedName("page") @Expose
    val page: Int,
    @SerializedName("per_page") @Expose
    val per_page: Int,
    @SerializedName("photos") @Expose
    val photos: List<PhotoDto>
)
