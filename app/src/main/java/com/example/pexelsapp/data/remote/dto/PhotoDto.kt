package com.example.pexelsapp.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PhotoDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("photographer")
    val photographer: String,
    @SerializedName("src")
    val src: SrcDto,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)
