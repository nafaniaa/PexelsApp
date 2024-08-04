package com.example.pexelsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.pexelsapp.domain.models.PhotoModel


interface PhotoRepository {
    suspend fun insert(photo: PhotoModel)
    suspend fun update(photo: PhotoModel)
    suspend fun delete(photo: PhotoModel)
    fun getAllPhotos(): LiveData<List<PhotoModel>>
    fun getPhotoById(id: Int): LiveData<PhotoModel>
    suspend fun getPhotos(): List<PhotoModel>
}