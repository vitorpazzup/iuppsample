package com.itau.service.impl

import com.itau.client.ProductClient
import com.itau.model.Events
import com.itau.model.EventsInformationDto
import com.itau.model.Product
import com.itau.model.dto.ProductDto
import com.itau.service.ProductService
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val client: ProductClient): ProductService {
    override fun testNats(product: ProductDto): ProductDto {
        val eventsInformation = EventsInformationDto(
            Events.SAVE_PRODUCT,
            Product(1L,product.name,product.price)
        )
        client.send(eventsInformation)
        return product
    }
}