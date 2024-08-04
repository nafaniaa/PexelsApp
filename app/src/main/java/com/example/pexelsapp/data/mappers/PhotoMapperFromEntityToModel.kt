package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel

// This file contains mapper functions that convert Photo entities to PhotoModel domain objects

// The toDomainModel() function takes a Photo entity as input
// and returns a PhotoModel domain object
fun Photo.toDomainModel(): PhotoModel {
    return PhotoModel(
        id = id,
        title = title,
        url = url,
        description = description,
        photographer = photographer,
        src = src
    )
}

// The toDomainModelList() function takes a list of Photo entities as input
// and returns a list of PhotoModel domain objects
fun List<Photo>.toDomainModelList(): List<PhotoModel> {
    // We use the map() function to convert each Photo entity in the list to a PhotoModel domain object
    return this.map { it.toDomainModel() }
}