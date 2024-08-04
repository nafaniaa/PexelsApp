package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.repositories.PhotoRepository
import com.example.pexelsapp.domain.models.PhotoModel
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(): List<PhotoModel> {
        return repository.getPhotos()
    }
}