package com.example.pexelsapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey val id: Int,
    val title: String,
    val url: String
)
