package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.remote.dto.PhotoDto
import com.example.pexelsapp.domain.models.PhotoModel

fun List<PhotoDto>.toDomainModelList(): List<PhotoModel> {
    return map { photoDto -> photoDto.toDomainModel() }
}

fun PhotoDto.toDomainModel(): PhotoModel {
    return PhotoModel(
        id = this.id,
        url = this.url,
        photographer = this.photographer,
        description = this.description,
        src = this.src,
        title = this.title
    )
}

