package com.example.pexelsapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.entities.Photo

@Database(entities = [Photo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // This is the main Room database class that defines the database schema and provides access to the DAO interfaces

    // The @Database annotation specifies the entities that are part of this database
    // and the current version of the database schema (1)

    // The AppDatabase class is abstract and extends the RoomDatabase class
    // It provides the necessary setup and management for the Room database

    // The photoDao() method is an abstract function that returns the PhotoDao interface
    // This allows the application to access the CRUD operations defined in the PhotoDao
    abstract fun photoDao(): PhotoDao
}