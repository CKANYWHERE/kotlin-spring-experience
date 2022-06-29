package com.example.kotlinspringexperience.product.repository

import com.example.kotlinspringexperience.product.entity.Category
import com.example.kotlinspringexperience.product.repository.querydsl.CategorySupport
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository:
    JpaRepository<Category, Long>, CategorySupport{}