package com.example.kotlinspringexperience.product.dto

import com.example.kotlinspringexperience.product.entity.Category
import java.time.OffsetDateTime

data class CreateCategoryDto(
    val id: Long = 0,
    val name: String = "",
){
    fun toEntity() : Category{
        return Category(
            id = id,
            name = name
        )
    }
}

data class CategoryResponseDto(
    val id: Long = 0,
    val name: String = "",
    val createdAt: OffsetDateTime = OffsetDateTime.MAX
)

data class CategoryDeleteResponseDto(
    val id: Long = 0,
    val isDeleted: Boolean = false
)

data class UpdateCategoryDto(
    val name: String = ""
)