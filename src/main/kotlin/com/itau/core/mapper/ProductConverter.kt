package com.itau.core.mapper

import com.itau.core.model.Product
import com.itau.entrypoint.dto.ProductDto
import com.itau.infrastructure.model.ProductEvent

class ProductConverter {
    companion object {
        fun productDtoToProduct(productDto: ProductDto) =
            Product(productDto.id, productDto.name, productDto.price)
        fun productEventToProduct(productEvent: ProductEvent) =
            Product(productEvent.id, productEvent.name, productEvent.price)
        fun productToProductDto(product: Product) =
            ProductDto(product.id, product.name, product.price)
        fun productToProductEvent(product: Product) =
            ProductEvent(product.id, product.name, product.price)
    }
}