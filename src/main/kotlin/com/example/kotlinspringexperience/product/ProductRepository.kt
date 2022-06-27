package com.example.kotlinspringexperience.product

import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
    fun findAllBy() : List<Product>
}