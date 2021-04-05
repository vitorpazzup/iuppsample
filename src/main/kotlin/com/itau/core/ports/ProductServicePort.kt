package com.itau.core.ports

import com.itau.model.dto.ProductDto

interface ProductServicePort {
    fun sendNats(product: ProductDto): ProductDto
}