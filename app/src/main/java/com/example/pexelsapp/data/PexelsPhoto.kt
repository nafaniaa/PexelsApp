package com.example.pexelsapp.data

import com.example.pexelsapp.data.enums.PexelsSize

data class PexelsPhoto(
    val id: Int,  // Уникальный идентификатор фотографии.
    val width: Int,  // Ширина фотографии.
    val height: Int,  // Высота фотографии.
    val url: String,  // URL фотографии.
    val photographer: String,  // Имя фотографа.
    val src: Map<String, String>,  // URL различных размеров изображений.
    var isLiked : Boolean = false,  // Флаг, указывающий, понравилась ли фотография пользователю.
    var queryParam : String? = null,  // Значение параметра запроса для фотографии.
    var isCurated : Boolean = false  // Флаг, указывающий, является ли фотография подборкой.
): java.io.Serializable {  // Реализация интерфейса Serializable для возможности передачи объекта между компонентами.

    // Вторичный конструктор, вызываемый при создании объекта с пустыми значениями.
    constructor() : this(0, 0, 0, "", "", mapOf(), false)

    // Функция asEntity() преобразует объект PexelsPhotoDto в объект PexelsPhotoEntity,
    // который может быть сохранен в базе данных.
    fun asEntity() = PexelsPhotoEntity(
        id,
        width,
        height,
        url,
        photographer,
        src[PexelsSize.TINY.sizeName] ?: "",  // Получение URL миниатюрного изображения из карты.
        src[PexelsSize.SMALL.sizeName] ?: "",  // Получение URL маленького изображения из карты.
        src[PexelsSize.MEDIUM.sizeName] ?: "",  // Получение URL среднего изображения из карты.
        src[PexelsSize.LARGE.sizeName] ?: "",  // Получение URL большого изображения из карты.
        src[PexelsSize.ORIGINAL.sizeName] ?: "",  // Получение URL оригинального изображения из карты.
        isLiked,
        queryParam,
        isCurated
    )
}