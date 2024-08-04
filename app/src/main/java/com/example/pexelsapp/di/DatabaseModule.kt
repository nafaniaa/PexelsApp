package com.example.pexelsapp.di


import android.content.Context
import androidx.room.Room
import com.example.pexelsapp.data.local.dao.PhotoDao
import com.example.pexelsapp.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// This file defines the dependency injection module for the database-related components
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    // This method provides an instance of the AppDatabase, which is the main
    // database for the application. It is created using the Room library
    // and the application context.
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pexels_db"
        ).build()
    }

    // This method provides an instance of the PhotoDao, which is the data access
    // object for the PhotoModel entity in the database. It is obtained from the
    // AppDatabase instance.
    @Provides
    fun providePhotoDao(database: AppDatabase): PhotoDao {
        return database.photoDao()
    }
}