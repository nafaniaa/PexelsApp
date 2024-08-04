package com.example.pexelsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.pexelsapp.domain.models.PhotoModel


// This file contains an interface that defines the methods for a PhotoRepository
// The PhotoRepository is responsible for managing the persistence of PhotoModel data

interface PhotoRepository {
    // The insert() method is used to save a new PhotoModel to the database
    suspend fun insert(photo: PhotoModel)

    // The update() method is used to update an existing PhotoModel in the database
    suspend fun update(photo: PhotoModel)

    // The delete() method is used to delete a PhotoModel from the database
    suspend fun delete(photo: PhotoModel)

    // The getAllPhotos() method returns a LiveData object that represents
    // the list of all PhotoModel objects in the database
    fun getAllPhotos(): LiveData<List<PhotoModel>>

    // The getPhotoById() method returns a LiveData object that represents
    // a single PhotoModel object with the specified ID
    fun getPhotoById(id: Int): LiveData<PhotoModel>

    // The getPhotos() method returns a List of all PhotoModel objects
    // in the database
    suspend fun getPhotos(): List<PhotoModel>
}