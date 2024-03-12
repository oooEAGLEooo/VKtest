package com.example.testvk.Model

data class Product(
    val id: Long? = null, // Уникальный номер продукта
    val title: String? = null, // Название продукта
    val description: String? = null, // Описание продукта
    val thumbnail: String? = null // Ссылка на изображение продукта
)
