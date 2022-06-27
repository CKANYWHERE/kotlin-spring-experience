package com.example.kotlinspringexperience.product

import com.example.kotlinspringexperience.product.dto.CreateProductDto
import com.example.kotlinspringexperience.product.dto.ProductResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(val productRepository: ProductRepository) {
    fun getProducts(): List<ProductResponseDto>{
        val products = productRepository.findAll()
        return products.map { product: Product -> product.toResponseDto() }
    }

    @Transactional
    fun createProduct(createProductDto: CreateProductDto): CreateProductDto{
        val product = productRepository.save(createProductDto.toEntity())
        return product.toCreateDto(product.id!!)
    }
}