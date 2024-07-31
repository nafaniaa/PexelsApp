package com.example.pexelsapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.entities.Photo

@Database(entities = [Photo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}