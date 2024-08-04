package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.data.repositories.PhotoRepository
import com.example.pexelsapp.domain.models.PhotoModel
import javax.inject.Inject


// This class represents a use case for deleting a photo from the repository

class DeletePhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(photo: PhotoModel) {
        repository.delete(photo)
    }
}