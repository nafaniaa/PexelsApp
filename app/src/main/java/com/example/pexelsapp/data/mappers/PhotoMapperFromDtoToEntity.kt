package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.remote.dto.PhotoDto


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

fun List<PhotoDto>.toEntityList(): List<Photo> {
    return this.map { it.toEntity() }
}