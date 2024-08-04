package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// This file contains a data class that represents a single photo in the Pexels API response
data class PhotoDto(
    @SerializedName("id") @Expose
    val id: Int,
    @SerializedName("width") @Expose
    val width: Int,
    @SerializedName("height") @Expose
    val height: Int,
    @SerializedName("url") @Expose
    val url: String,
    @SerializedName("photographer") @Expose
    val photographer: String,
    @SerializedName("src") @Expose
    val src: SrcDto
)
