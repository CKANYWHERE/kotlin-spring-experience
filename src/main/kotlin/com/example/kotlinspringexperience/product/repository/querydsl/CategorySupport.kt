package com.example.kotlinspringexperience.product.repository.querydsl

import com.example.kotlinspringexperience.product.vo.CategoryVo

interface CategorySupport {
    fun updateCategoryById(id:Long, name:String): Long
    fun findCategoryById(id: Long): CategoryVo?
}