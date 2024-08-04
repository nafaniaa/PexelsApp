package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.remote.dto.PhotoDto

// This file contains mapper functions that convert PhotoDto objects to Photo entities

// The toEntity() function takes a PhotoDto as input
// and returns a Photo entity
fun PhotoDto.toEntity(): Photo {
    return Photo(
        id = id,
        title = photographer,
        url = src.original,
        description = "",
        photographer = photographer,
        src = src
    )
}

// The toEntityList() function takes a list of PhotoDto objects as input
// and returns a list of Photo entities
fun List<PhotoDto>.toEntityList(): List<Photo> {
    // We use the map() function to convert each PhotoDto in the list to a Photo entity
    return this.map { it.toEntity() }
}