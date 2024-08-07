package com.example.pexelsapp.domain.models

import com.example.pexelsapp.data.remote.dto.SrcDto



data class PhotoModel(
    val id: Int,
    val title: String,
    val url: String,
    val description: String,
    val photographer: String,
    val src: SrcDto
)