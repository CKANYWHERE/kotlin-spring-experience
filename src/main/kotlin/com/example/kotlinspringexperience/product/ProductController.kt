package com.example.kotlinspringexperience.product

import com.example.kotlinspringexperience.product.dto.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductService) {

    @GetMapping(produces = ["application/json"])
    fun getProducts(): ResponseEntity<List<ProductResponseDto>> {
        return ResponseEntity
            .ok()
            .body(productService.getProducts())
    }

    @PostMapping()
    fun createProduct(@RequestBody createProductDto: CreateProductDto): ResponseEntity<CreateProductDto> {
        val product = productService.createProduct(createProductDto)
        return ResponseEntity.ok().body(product)
    }

    @PostMapping("/category")
    fun createCategory(@RequestBody createCategoryDto: CreateCategoryDto): ResponseEntity<CreateCategoryDto> {
        val category = productService.createCategory(createCategoryDto)
        return ResponseEntity.ok().body(category)
    }

    @PutMapping("/category/{id}")
    fun updateCategory(@RequestBody dto: UpdateCategoryDto, @PathVariable id: Long): ResponseEntity<CategoryResponseDto> {
        val category = productService.updateCategory(id, dto.name)
        return ResponseEntity.ok().body(category)
    }
}