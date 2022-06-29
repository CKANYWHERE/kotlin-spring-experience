package com.example.kotlinspringexperience.product

import com.example.kotlinspringexperience.product.dto.CategoryResponseDto
import com.example.kotlinspringexperience.product.dto.CreateCategoryDto
import com.example.kotlinspringexperience.product.dto.CreateProductDto
import com.example.kotlinspringexperience.product.dto.ProductResponseDto
import com.example.kotlinspringexperience.product.entity.Product
import com.example.kotlinspringexperience.product.repository.CategoryRepository
import com.example.kotlinspringexperience.product.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
class ProductService(
    val productRepository: ProductRepository,
    val categoryRepository: CategoryRepository
    ) {
    fun getProducts(): List<ProductResponseDto>{
        val products = productRepository.findAll()
        return products.map { product: Product -> product.toResponseDto() }
    }

    @Transactional
    fun createProduct(createProductDto: CreateProductDto): CreateProductDto{
        val product = productRepository.save(createProductDto.toEntity())
        return product.toCreateDto(product.id!!)
    }

    @Transactional
    fun createCategory(createCategoryDto: CreateCategoryDto): CreateCategoryDto {
        val category = categoryRepository.save(createCategoryDto.toEntity())
        return category.toCreateDto(category.id!!)
    }

    @Transactional
    fun updateCategory(id:Long, name:String): CategoryResponseDto{
        categoryRepository.updateCategoryById(id, name)
        val vo = categoryRepository.findCategoryById(id)
        return CategoryResponseDto(
            vo?.id ?: 0,
            vo?.name ?: "",
            vo?.createdAt ?: OffsetDateTime.MAX,
        )
    }
}