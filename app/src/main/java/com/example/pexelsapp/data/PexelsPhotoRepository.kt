package com.example.pexelsapp.data

import com.example.pexelsapp.PexelsApplication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import com.example.pexelsapp.data.PexelsPhotoDao
import com.example.pexelsapp.network.PexelsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/*
class PhotosRepository(
    private val app: PexelsApplication
) {
    private val pexelsPhotoDao: PexelsPhotoDao = app.database.pexelsPhotoDao()
    val databaseDispatcher: CoroutineDispatcher = Dispatchers.IO

    val photosFlow: Flow<List<PexelsPhotoEntity>> = pexelsPhotoDao.getAll()
    val likedPhotosFlow: Flow<List<PexelsPhotoEntity>> = pexelsPhotoDao.getAllLiked()

    suspend fun isPhotosTableEmpty() = withContext(databaseDispatcher) {
        pexelsPhotoDao.isEmpty()
    }

    suspend fun insertPhoto(photo: PexelsPhotoEntity) = withContext(databaseDispatcher) {
        pexelsPhotoDao.insert(photo)
    }

    suspend fun getPhotoById(id: Int): PexelsPhotoEntity = withContext(databaseDispatcher) {
        pexelsPhotoDao.getById(id)
    }

    fun getLikedPhotos() = pexelsPhotoDao.getAllLiked()

    fun getAllPhotos() = pexelsPhotoDao.getAll()
}*/

interface PhotosRepository{
    suspend fun getPhotos(query: String, perPage: Int, page: Int) : List<PexelsPhoto>
}

class NetworkPhotosRepository(
    private val pexelsApi: PexelsApi
) : PhotosRepository {
    override suspend fun getPhotos(
        query: String,
        perPage: Int, page: Int
    ): List<PexelsPhoto> = pexelsApi.searchPhotos(query, perPage, page).photos.map {photos ->
        PexelsPhoto(
            id = photos.id,
            width = photos.width,
            height = photos.height,
            url = photos.url,
            photographer = photos.photographer,
            src = photos.src,
            isLiked = photos.isLiked,
            queryParam = photos.queryParam,
            isCurated = photos.isCurated
        )

    }
}
