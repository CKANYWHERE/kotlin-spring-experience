package com.example.kotlinspringexperience.product

import com.example.kotlinspringexperience.product.dto.CreateProductDto
import com.example.kotlinspringexperience.product.dto.ProductResponseDto
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

}