package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// This file contains a data class that represents the source URLs of a photo in the Pexels API response

data class SrcDto(
    @SerializedName("original") @Expose
    val original: String,
    @SerializedName("medium") @Expose
    val medium: String
)