package com.example.pexelsapp.data.repositories

import androidx.lifecycle.LiveData
import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.entities.Photo
import javax.inject.Inject


//class PhotoRepositoryImpl @Inject constructor(
//    private val photoDao: PhotoDao
//) : PhotoRepository {
//    override suspend fun insert(photo: Photo) {
//        photoDao.insert(photo)
//    }
//
//    override suspend fun update(photo: Photo) {
//        photoDao.update(photo)
//    }
//
//    override suspend fun delete(photo: Photo) {
//        photoDao.delete(photo)
//    }
//
//    override fun getAllPhotos(): LiveData<List<Photo>> {
//        return photoDao.getAllPhotos()
//    }
//
//    override fun getPhotoById(id: Int): LiveData<Photo> {
//        return photoDao.getPhotoById(id)
//    }
//}
