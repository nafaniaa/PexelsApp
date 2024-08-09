package com.example.pexelsapp.data.repositories

import com.example.pexelsapp.domain.models.PhotoModel
import kotlinx.coroutines.flow.Flow


interface PhotoRepository {
    suspend fun insertPhoto(photo: PhotoModel)
    suspend fun updatePhoto(photo: PhotoModel)
    suspend fun deletePhoto(photo: PhotoModel)
    fun getAllPhotos(): Flow<List<PhotoModel>>
    fun getPhotoById(id: Int): Flow<PhotoModel?>
    suspend fun getPhotos(query: String, perPage: Int, page: Int): List<PhotoModel>
    suspend fun getAndSavePhotos(query: String, perPage: Int, page: Int)
}