package com.itau.entrypoint.controller

import com.itau.core.mapper.ProductConverter
import com.itau.core.ports.ProductServicePort
import com.itau.entrypoint.dto.ProductDto
import com.itau.entrypoint.utils.ProductUtils
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/iupp/v1/product")
class ProductController(private val service: ProductServicePort) {
    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun saveProduct(@Body productDto: ProductDto): ProductDto {
        ProductUtils.productValid(productDto)
        return service.productMessage(ProductConverter.productDtoToProduct(productDto))
    }
}