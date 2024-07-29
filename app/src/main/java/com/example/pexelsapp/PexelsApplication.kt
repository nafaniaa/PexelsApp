
package com.example.pexelsapp

import android.app.Application
import androidx.room.Room
import com.example.pexelsapp.data.local.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PexelsApplication : Application() {

}