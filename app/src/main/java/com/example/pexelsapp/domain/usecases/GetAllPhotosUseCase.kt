package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.repositories.PhotoRepository
import javax.inject.Inject

// This class represents a use case for fetching all photos from the repository
class GetAllPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke() = repository.getAllPhotos()
}