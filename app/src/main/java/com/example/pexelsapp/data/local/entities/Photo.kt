package com.example.pexelsapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pexelsapp.data.remote.dto.SrcDto


@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "url")val url: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "photographer")val photographer: String,
    @ColumnInfo(name = "src")val src: SrcDto
)