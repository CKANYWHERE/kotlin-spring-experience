package com.example.kotlinspringexperience.product.repository.querydsl.impl

import com.example.kotlinspringexperience.config.CustomQuerydslRepositorySupport
import com.example.kotlinspringexperience.product.entity.Category
import com.example.kotlinspringexperience.product.entity.QCategory.category
import com.example.kotlinspringexperience.product.repository.querydsl.CategorySupport
import com.example.kotlinspringexperience.product.vo.CategoryVo
import com.example.kotlinspringexperience.product.vo.QCategoryVo
import com.querydsl.jpa.impl.JPAQueryFactory

class CategoryRepositoryImpl(private val query: JPAQueryFactory) :
    CustomQuerydslRepositorySupport(Category::class.java), CategorySupport{

    override fun updateCategoryById(id:Long, name:String): Long {
        return query
            .update(category)
            .set(category.name, name)
            .where(category.id.eq(id))
            .execute()
    }

    override fun deleteCategoryById(id: Long): Long {
        return query.delete(category).where(category.id.eq(id)).execute()
    }

    override fun findCategoryById(id: Long): CategoryVo? {
       return query.select(
           QCategoryVo(
               category.id!!,
               category.name,
               category.createdAt
           )
       ).from(category).where(category.id.eq(id)).fetchOne()
    }
}