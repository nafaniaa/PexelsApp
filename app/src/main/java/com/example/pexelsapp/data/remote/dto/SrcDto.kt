package com.example.pexelsapp.data.remote.dto

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class SrcDto(
    @SerializedName("original")
    val original: String,
    @SerializedName("medium")
    val medium: String
)


class Converters {

    @TypeConverter
    fun fromSrcDto(srcDto: SrcDto): String {
        return Gson().toJson(srcDto)
    }

    @TypeConverter
    fun toSrcDto(srcString: String): SrcDto {
        return Gson().fromJson(srcString, SrcDto::class.java)
    }
}