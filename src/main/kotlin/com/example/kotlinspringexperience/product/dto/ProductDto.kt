package com.example.kotlinspringexperience.product.dto

import com.example.kotlinspringexperience.product.entity.Category
import com.example.kotlinspringexperience.product.entity.Product
import java.time.OffsetDateTime

data class ProductResponseDto(
    val id: Long? = null,
    val name: String,
    val category: Category,
    val createdAt: OffsetDateTime
)

data class CreateProductDto(
    val id: Long,
    val name: String,
    val category: Category
){
    fun toEntity() : Product {
        return Product(
            name = name,
            category = category,
        )
    }
}