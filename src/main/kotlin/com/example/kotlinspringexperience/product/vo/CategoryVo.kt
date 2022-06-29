package com.example.kotlinspringexperience.product.vo

import com.querydsl.core.annotations.QueryProjection
import java.time.OffsetDateTime

class CategoryVo @QueryProjection constructor(
    val id: Long? = null,
    val name: String,
    val createdAt: OffsetDateTime
)