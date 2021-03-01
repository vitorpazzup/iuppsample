package com.itau.service

import com.itau.model.dto.ProductDto

interface ProductService {
    fun testNats(product: ProductDto): ProductDto
}