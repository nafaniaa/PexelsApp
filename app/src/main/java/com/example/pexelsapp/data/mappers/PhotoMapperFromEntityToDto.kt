package com.example.pexelsapp.data.mappers

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.remote.dto.PhotoDto
import com.example.pexelsapp.data.remote.dto.SrcDto

// This file contains a mapper function that converts a Photo entity to a PhotoDto

// The toDto() function takes a Photo entity as input
// and returns a PhotoDto object
fun Photo.toDto(): PhotoDto {
    return PhotoDto(
        id = this.id,
        width = 0,
        height = 0,
        url = this.url,
        photographer = this.title,
        src = SrcDto(this.url, this.url)
    )
}