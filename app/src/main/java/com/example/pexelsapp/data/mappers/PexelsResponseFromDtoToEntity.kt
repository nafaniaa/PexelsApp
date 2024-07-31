package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.remote.dto.PexelsResponseDto


fun PexelsResponseDto.toEntityList(): List<Photo> {
    return this.photos.map { it.toEntity() }
}