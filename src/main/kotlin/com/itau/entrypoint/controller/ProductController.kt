package com.itau.entrypoint.controller

import com.itau.core.mapper.ProductConverter
import com.itau.core.ports.ProductServicePort
import com.itau.entrypoint.dto.ProductDto
import com.itau.entrypoint.utils.ProductUtils
import io.micronaut.context.annotation.Value
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/iupp/v1/product")
class ProductController(private val service: ProductServicePort) {
    
    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun saveProduct(@Body productDto: ProductDto): ProductDto {
        ProductUtils.productValid(productDto)
        return service.productMessage(ProductConverter.productDtoToProduct(productDto))
    }
}