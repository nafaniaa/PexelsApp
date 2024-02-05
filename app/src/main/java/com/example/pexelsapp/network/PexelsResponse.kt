package com.example.pexelsapp.network

import com.example.pexelsapp.data.PexelsPhoto


data class PexelsResponse(
    val photos: List<PexelsPhoto>
)