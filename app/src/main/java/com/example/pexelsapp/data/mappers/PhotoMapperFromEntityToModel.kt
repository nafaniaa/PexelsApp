package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel

fun Photo.toDomainModel(): PhotoModel {
    return PhotoModel(
        id = id,
        title = title,
        url = url,
        description = description
    )
}

fun List<Photo>.toDomainModelList(): List<PhotoModel> {
    return this.map { it.toDomainModel() }
}