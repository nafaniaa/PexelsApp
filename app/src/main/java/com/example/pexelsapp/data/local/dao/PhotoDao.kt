package com.example.pexelsapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pexelsapp.data.local.entities.Photo

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: Photo)

    @Update
    suspend fun update(photo: Photo)

    @Delete
    suspend fun delete(photo: Photo)

    @Query("SELECT * FROM photos")
    fun getAllPhotos(): LiveData<List<Photo>>

    @Query("SELECT * FROM photos WHERE id = :id")
    fun getPhotoById(id: Int): LiveData<Photo>


}