package com.example.pexelsapp.data.repositories

import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.mappers.toDomainModel
import com.example.pexelsapp.data.mappers.toDomainModelList
import javax.inject.Inject
import com.example.pexelsapp.data.mappers.toEntity
import com.example.pexelsapp.data.mappers.toEntityList
import com.example.pexelsapp.data.remote.PexelsApi
import com.example.pexelsapp.domain.models.PhotoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class PhotoRepositoryImpl @Inject constructor(
    private val photoDao: PhotoDao,
    private val pexelsApi: PexelsApi
) : PhotoRepository {
    override suspend fun insertPhoto(photo: PhotoModel) {
        photoDao.insertPhoto(photo.toEntity())
    }

    override suspend fun updatePhoto(photo: PhotoModel) {
        photoDao.updatePhoto(photo.toEntity())
    }

    override suspend fun deletePhoto(photo: PhotoModel) {
        photoDao.deletePhoto(photo.toEntity())
    }

    override fun getAllPhotos(): Flow<List<PhotoModel>> {
        return photoDao.getAllPhotos().map { entities ->
            entities.toDomainModelList()
        }
    }

    override fun getPhotoById(id: Int): Flow<PhotoModel?> {
        return photoDao.getPhotoById(id).map { entity ->
            entity?.toDomainModel()
        }
    }

    override suspend fun getPhotos(query: String, perPage: Int, page: Int): List<PhotoModel> {
        val response = pexelsApi.searchPhotos(query, perPage, page)
        val photosResponse = response.body()
        return photosResponse?.photos?.map { it.toDomainModel() } ?: emptyList()
    }

    override suspend fun getAndSavePhotos(query: String, perPage: Int, page: Int) {
        val response = pexelsApi.searchPhotos(query, perPage, page)
        if (response.isSuccessful) {
            response.body()?.let { pexelsResponse ->
                val photos = pexelsResponse.photos.toEntityList()
                photoDao.insertAllPhotos(photos)
            }
        }
    }
}