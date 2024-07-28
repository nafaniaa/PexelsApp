package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SrcDto(
    @SerializedName("original") @Expose
    val original: String,
    @SerializedName("medium") @Expose
    val medium: String
)