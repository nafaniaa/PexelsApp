package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.repositories.PhotoRepository
import com.example.pexelsapp.domain.models.PhotoModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(): Flow<List<PhotoModel>> {
        return repository.getAllPhotos()
    }
}