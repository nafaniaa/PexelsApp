package com.example.pexelsapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pexelsapp.data.local.entities.Photo

@Dao
interface PhotoDao {
    @Insert
    suspend fun insert(photo: Photo)

    @Query("SELECT * FROM photos")
    suspend fun getAllPhotos(): List<Photo>


}