package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel

// This file contains mapper functions that convert PhotoModel domain objects to Photo entities

// The toEntity() function takes a PhotoModel domain object as input
// and returns a Photo entity
fun PhotoModel.toEntity(): Photo {
    return Photo(
        id = id,
        title = title,
        url = url,
        description = description,
        photographer = photographer,
        src = src
    )
}

// The toEntityList() function takes a list of PhotoModel domain objects as input
// and returns a list of Photo entities
fun List<PhotoModel>.toEntityList(): List<Photo> {
    // We use the map() function to convert each PhotoModel in the list to a Photo entity
    return this.map { it.toEntity() }
}