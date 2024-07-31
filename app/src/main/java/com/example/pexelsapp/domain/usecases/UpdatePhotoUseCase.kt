package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.repositories.PhotoRepository
import com.example.pexelsapp.domain.models.PhotoModel
import javax.inject.Inject

class UpdatePhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(photo: PhotoModel) {
        repository.update(photo)
    }
}