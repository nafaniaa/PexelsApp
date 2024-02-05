package com.example.pexelsapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pexelsapp.network.PexelsResponse

@Entity(tableName = "photos")
data class PexelsPhotoEntity(
    @PrimaryKey
    val id: Int,  // Уникальный идентификатор фотографии, является первичным ключом.
    val width: Int,  // Ширина фотографии.
    val height: Int,  // Высота фотографии.
    val url: String,  // URL фотографии.
    val photographer: String,  // Имя фотографа.
    val tiny: String,  // URL миниатюрного изображения.
    val small: String,  // URL маленького изображения.
    val medium: String,  // URL среднего изображения.
    val large: String,  // URL большого изображения.
    val original: String,  // URL оригинального изображения.
    var isLiked: Boolean = false,  // Флаг, указывающий, понравилась ли фотография пользователю.
    @ColumnInfo(name = "query_param")  // Имя параметра запроса для фотографии.
    var queryParam: String? = null,
    @ColumnInfo(name = "is_curated")  // Флаг, указывающий, является ли фотография подборкой.
    var isCurated: Boolean = false
){
    // Компаньон-объект содержит функцию empty(), которая создает и возвращает
    // пустой объект PexelsPhotoEntity с нулевыми или пустыми значениями.
    companion object {
        fun empty(): PexelsPhotoEntity {
            return PexelsPhotoEntity(
                id = 0,
                width = 0,
                height = 0,
                url = "",
                photographer = "",
                tiny = "",
                small = "",
                medium = "",
                large = "",
                original = "",
                isLiked = false,
                queryParam = "",
                isCurated = false
            )
        }
    }

    // Функция asPhoto() преобразует объект PexelsPhotoEntity в объект PexelsPhoto.
    fun asPhoto() = PexelsPhoto(
        id,
        width,
        height,
        url,
        photographer,
        mapOf(
            Pair("tiny", tiny),
            Pair("small", small),
            Pair("medium", medium),
            Pair("large", large),
            Pair("original", original)
        ),
        isLiked,
        queryParam,
        isCurated
    )
}
