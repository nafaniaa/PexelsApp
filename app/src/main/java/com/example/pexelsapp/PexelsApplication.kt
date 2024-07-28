
package com.example.pexelsapp

import android.app.Application
import androidx.room.Room
import com.example.pexelsapp.data.local.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PexelsApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "pexels_db"
        ).build()
    }
}