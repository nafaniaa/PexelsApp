package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel

fun PhotoModel.toEntity(): Photo {
    return Photo(
        id = id,
        title = title,
        url = url,
        description = description
    )
}


fun List<PhotoModel>.toEntityList(): List<Photo> {
    return this.map { it.toEntity() }
}