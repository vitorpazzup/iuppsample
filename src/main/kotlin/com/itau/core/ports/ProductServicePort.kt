package com.itau.core.ports

import com.itau.entrypoint.dto.ProductDto


interface ProductServicePort {
    fun sendNats(product: ProductDto): ProductDto
}