package com.example.pexelsapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pexelsapp.data.remote.dto.SrcDto

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val url: String,
    val description: String,
    val photographer: String,
    val src: SrcDto
)