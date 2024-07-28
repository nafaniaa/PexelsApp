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

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "photos.db"
        ).build()
    }

    @Provides
    fun providePhotoDao(database: AppDatabase): PhotoDao {
        return database.photoDao()
    }
}