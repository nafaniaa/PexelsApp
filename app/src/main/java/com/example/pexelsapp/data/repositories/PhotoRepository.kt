package com.example.pexelsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.pexelsapp.data.local.entities.Photo

interface PhotoRepository {
    suspend fun insert(photo: Photo)
    suspend fun update(photo: Photo)
    suspend fun delete(photo: Photo)
    fun getAllPhotos(): LiveData<List<Photo>>
    fun getPhotoById(id: Int): LiveData<Photo>
}