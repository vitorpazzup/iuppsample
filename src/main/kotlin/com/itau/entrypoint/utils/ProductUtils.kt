package com.itau.entrypoint.utils

import com.itau.entrypoint.controller.handler.ProductException
import com.itau.model.dto.ProductDto
import java.math.BigDecimal

class ProductUtils {
    companion object {
        fun productValid(productDto: ProductDto): ProductDto {
            try {
            nameIsValid(productDto.name)
            priceIsValid(productDto.price)
            return productDto
            }catch (ex: IllegalArgumentException){
                throw ProductException()
            }
        }
        private fun nameIsValid(name: String) {
            if (name.isNullOrEmpty()) {
                throw IllegalArgumentException()
            }
        }
        private fun priceIsValid(price: BigDecimal) {
            if (price <= BigDecimal.ZERO) {
                throw IllegalArgumentException()
            }
        }
    }
}