package com.example.kotlinspringexperience.product.entity

import com.example.kotlinspringexperience.product.dto.CreateProductDto
import com.example.kotlinspringexperience.product.dto.ProductResponseDto
import java.time.OffsetDateTime
import javax.persistence.*


@Entity
@Table(
    name = "product",
    indexes = [Index(name = "idx_category_id" ,columnList = "category_id")]
)
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "category_id",
        insertable = false,
        updatable = false,
        foreignKey = ForeignKey(name = "none")
    )
    var category: Category,

    @Column(name = "created_at")
    var createdAt: OffsetDateTime = OffsetDateTime.now(),

    @Column(name = "updated_at")
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

