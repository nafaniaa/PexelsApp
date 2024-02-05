package com.example.pexelsapp

import android.app.Application
import com.example.pexelsapp.data.PexelsPhotoDatabase
import com.example.pexelsapp.network.PexelsApiClient
import com.example.pexelsapp.network.PexelsAppContainer

class PexelsApplication : Application() {
    lateinit var container: PexelsAppContainer
    override fun onCreate() {
        super.onCreate()
        container = PexelsApiClient(this)
    }
    val database by lazy {PexelsPhotoDatabase.instance(this)}
}