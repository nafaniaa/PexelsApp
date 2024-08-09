package com.example.pexelsapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel
import kotlinx.coroutines.flow.Flow


@Dao
interface PhotoDao {
    @Insert
    suspend fun insertPhoto(photo: Photo)
    @Update
    suspend fun updatePhoto(photo: Photo)

    @Delete
    suspend fun deletePhoto(photo: Photo)

    @Query("SELECT * FROM photos")
    fun getAllPhotos(): Flow<List<Photo>>

    @Query("SELECT * FROM photos WHERE id = :id")
    fun getPhotoById(id: Int): Flow<Photo>

    @Insert
    suspend fun insertAllPhotos(photos: List<Photo>)

    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): List<PhotoModel>
}