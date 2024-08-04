package com.example.pexelsapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map

import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.mappers.toDomainModel
import com.example.pexelsapp.data.mappers.toDomainModelList
import javax.inject.Inject
import com.example.pexelsapp.data.mappers.toEntity
import com.example.pexelsapp.data.mappers.toEntityList
import com.example.pexelsapp.data.remote.PexelsApi
import com.example.pexelsapp.domain.models.PhotoModel


// This file contains an implementation of the PhotoRepository interface
// using a PhotoDao and a PexelsApi instance

class PhotoRepositoryImpl @Inject constructor(
    // The PhotoDao is used to perform CRUD operations on the PhotoModel data
    private val photoDao: PhotoDao,
    // The PexelsApi is used to fetch photos from the Pexels API
    private val pexelsApi: PexelsApi
) : PhotoRepository {

    // The insert() method saves a new PhotoModel to the database
    override suspend fun insert(photo: PhotoModel) {
        photoDao.insert(photo.toEntity())
    }

    // The update() method updates an existing PhotoModel in the database
    override suspend fun update(photo: PhotoModel) {
        photoDao.update(photo.toEntity())
    }

    // The delete() method deletes a PhotoModel from the database
    override suspend fun delete(photo: PhotoModel) {
        photoDao.delete(photo.toEntity())
    }

    // The getAllPhotos() method returns a LiveData object that represents
    // the list of all PhotoModel objects in the database
    override fun getAllPhotos(): LiveData<List<PhotoModel>> {
        return photoDao.getAllPhotos().map { entities ->
            entities.toDomainModelList()
        }
    }

    // The getPhotoById() method returns a LiveData object that represents
    // a single PhotoModel object with the specified ID
    override fun getPhotoById(id: Int): LiveData<PhotoModel> {
        return photoDao.getPhotoById(id).map { entity ->
            entity.toDomainModel()
        }
    }

    // The getPhotos() method returns a List of all PhotoModel objects
    // in the database
    override suspend fun getPhotos(): List<PhotoModel> {
        return photoDao.getPhotos()
    }

    // The fetchAndSavePhotos() method fetches photos from the Pexels API
    // and saves them to the database
    suspend fun fetchAndSavePhotos(query: String, perPage: Int = 15, page: Int = 1) {
        // Call the searchPhotos() method on the PexelsApi instance
        val response = pexelsApi.searchPhotos(query, perPage, page)
        // Check if the response is successful
        if (response.isSuccessful) {
            // Get the response body and save the photos to the database
            response.body()?.let { pexelsResponse ->
                val photos = pexelsResponse.photos.toEntityList()
                photoDao.insertAll(photos)
            }
        }
    }
}