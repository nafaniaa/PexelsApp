package com.example.pexelsapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pexelsapp.data.local.entities.Photo
import com.example.pexelsapp.domain.models.PhotoModel

// This is the Data Access Object (DAO) interface for the Photo entity
// It defines the CRUD (Create, Read, Update, Delete) operations for the Photo table in the Room database
@Dao
interface PhotoDao {
    // Insert a single Photo entity into the database
    @Insert
    suspend fun insert(photo: Photo)

    // Update a single Photo entity in the database
    @Update
    suspend fun update(photo: Photo)

    // Delete a single Photo entity from the database
    @Delete
    suspend fun delete(photo: Photo)

    // Retrieve all Photo entities from the database as a LiveData<List<Photo>>
    @Query("SELECT * FROM photos")
    fun getAllPhotos(): LiveData<List<Photo>>

    // Retrieve a single Photo entity from the database by its id as a LiveData<Photo>
    @Query("SELECT * FROM photos WHERE id = :id")
    fun getPhotoById(id: Int): LiveData<Photo>

    // Insert a list of Photo entities into the database
    @Insert
    suspend fun insertAll(photos: List<Photo>)

    // Retrieve all Photo entities from the database as a List<PhotoModel>
    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): List<PhotoModel>
}