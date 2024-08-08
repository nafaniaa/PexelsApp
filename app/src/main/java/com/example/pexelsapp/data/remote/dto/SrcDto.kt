package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class SrcDto(
    @SerializedName("original")
    val original: String,
    @SerializedName("medium")
    val medium: String
)