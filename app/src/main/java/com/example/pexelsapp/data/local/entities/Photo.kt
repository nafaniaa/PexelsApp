package com.example.pexelsapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pexelsapp.data.remote.dto.SrcDto

// This is the Photo entity class that represents a single photo in the database
@Entity(tableName = "photos")
data class Photo(
    // The @PrimaryKey annotation marks the id property as the primary key
    // and the autoGenerate = true flag tells Room to automatically generate a unique id for each new entity
    @PrimaryKey(autoGenerate = true) val id: Int,

    // The other properties of the Photo entity correspond to the columns in the "photos" table
    val title: String,
    val url: String,
    val description: String,
    val photographer: String,

    // The src property is a separate data class that holds the different sources of the photo
    val src: SrcDto
)