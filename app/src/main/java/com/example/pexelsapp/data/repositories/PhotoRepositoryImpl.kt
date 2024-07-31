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


class PhotoRepositoryImpl @Inject constructor(
    private val photoDao: PhotoDao,
    private val pexelsApi: PexelsApi
) : PhotoRepository {

    override suspend fun insert(photo: PhotoModel) {
        photoDao.insert(photo.toEntity())
    }

    override suspend fun update(photo: PhotoModel) {
        photoDao.update(photo.toEntity())
    }

    override suspend fun delete(photo: PhotoModel) {
        photoDao.delete(photo.toEntity())
    }

    override fun getAllPhotos(): LiveData<List<PhotoModel>> {
        return photoDao.getAllPhotos().map { entities ->
            entities.toDomainModelList()
        }
    }

    override fun getPhotoById(id: Int): LiveData<PhotoModel> {
        return photoDao.getPhotoById(id).map { entity ->
            entity.toDomainModel()
        }
    }


    suspend fun fetchAndSavePhotos(query: String, perPage: Int = 15, page: Int = 1) {
        val response = pexelsApi.searchPhotos(query, perPage, page)
        if (response.isSuccessful) {
            response.body()?.let { pexelsResponse ->
                val photos = pexelsResponse.photos.toEntityList()
                photoDao.insertAll(photos)
            }
        }
    }
}