package com.itau.core.ports

import com.itau.core.model.Product
import com.itau.entrypoint.dto.ProductDto
import javax.inject.Singleton

@Singleton
interface ProductServicePort {
    fun productMessage(product: Product): ProductDto
}