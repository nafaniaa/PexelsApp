package com.example.pexelsapp.domain.usecases

import com.example.pexelsapp.data.repositories.PhotoRepository
import com.example.pexelsapp.domain.models.PhotoModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetPhotoByIdUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    operator fun invoke(id: Int): Flow<PhotoModel?> {
        return repository.getPhotoById(id)
    }
}