package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.remote.dto.PexelsResponseDto

// This file contains a mapper function that converts a PexelsResponseDto to a list of Photo entities

// The toEntityList() function takes a PexelsResponseDto as input
// and returns a list of Photo entities
fun PexelsResponseDto.toEntityList(): List<Photo> {
    // The photos property of the PexelsResponseDto contains a list of PhotoDto objects
    // We use the map() function to convert each PhotoDto to a Photo entity
    return this.photos.map { it.toEntity() }
}