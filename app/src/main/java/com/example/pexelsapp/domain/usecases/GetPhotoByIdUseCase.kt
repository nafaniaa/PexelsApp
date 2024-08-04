package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.repositories.PhotoRepository
import javax.inject.Inject

// This class represents a use case for fetching a photo by its ID from the repository
class GetPhotoByIdUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(id: Int) = repository.getPhotoById(id)
}