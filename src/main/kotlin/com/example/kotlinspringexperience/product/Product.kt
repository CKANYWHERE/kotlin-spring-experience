package com.example.kotlinspringexperience.product

import com.example.kotlinspringexperience.product.dto.CreateProductDto
import com.example.kotlinspringexperience.product.dto.ProductResponseDto
import java.time.OffsetDateTime
import javax.persistence.*

enum class Category {
    Phone, Laptop, Keyboard
}

@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var category: Category,
    var createdAt: OffsetDateTime = OffsetDateTime.now(),
    var updatedAt: OffsetDateTime? = null
){
    fun toResponseDto(): ProductResponseDto {
        return ProductResponseDto(
            id = id,
            name = name,
            category = category,
            createdAt = createdAt
        )
    }

    fun toCreateDto(id: Long): CreateProductDto {
        return CreateProductDto(
            id = id,
            name = name,
            category = category
        )
    }
}

