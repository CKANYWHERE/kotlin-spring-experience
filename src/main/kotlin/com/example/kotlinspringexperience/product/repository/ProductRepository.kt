package com.example.kotlinspringexperience.product.repository

import com.example.kotlinspringexperience.product.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun findAllBy() : List<Product>
}