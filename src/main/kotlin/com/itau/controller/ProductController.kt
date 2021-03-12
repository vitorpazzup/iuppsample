package com.itau.controller

import com.itau.model.dto.ProductDto
import com.itau.service.ProductService
import com.itau.utils.ProductUtils
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/iupp/v1/product")
class ProductController(private val service: ProductService) {
    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun saveProduct(@Body product: ProductDto): ProductDto {
        ProductUtils.productValid(product)
        return service.testNats(product)
    }
}