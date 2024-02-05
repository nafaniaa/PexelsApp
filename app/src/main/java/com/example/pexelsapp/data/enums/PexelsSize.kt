package com.example.pexelsapp.data.enums

// Enum class PexelsSize представляет перечисление различных размеров изображений на Pexels.
// Каждый элемент этого перечисления соответствует определенному размеру изображения
// и содержит связанное с ним имя размера.
enum class PexelsSize(val sizeName: String) {
    TINY("tiny"),       // Миниатюрный размер изображения.
    SMALL("small"),      // Маленький размер изображения.
    MEDIUM("medium"),    // Средний размер изображения.
    LARGE("large"),      // Большой размер изображения.
    ORIGINAL("original"); // Оригинальный размер изображения.

    // Компаньон-объект содержит функцию fromName, которая принимает имя размера в виде строки
    // и возвращает соответствующий элемент перечисления PexelsSize или null, если размер не найден.
    companion object {
        fun fromName(name: String): PexelsSize? = PexelsSize.values().find { it.sizeName == name }
    }
}