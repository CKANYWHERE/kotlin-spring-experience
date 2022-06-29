package com.example.kotlinspringexperience.product.entity

import com.example.kotlinspringexperience.product.dto.*
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "category")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "name")
    var name: String,

    @Column(name = "created_at")
    var createdAt: OffsetDateTime = OffsetDateTime.now(),

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    var products: MutableList<Product> = mutableListOf()
){
    fun toResponseDto(): CategoryResponseDto {
        return CategoryResponseDto(
            id = id,
            name = name,
            createdAt = createdAt
        )
    }

    fun toCreateDto(id: Long): CreateCategoryDto {
        return CreateCategoryDto(
            id = id,
            name = name
        )
    }
}
