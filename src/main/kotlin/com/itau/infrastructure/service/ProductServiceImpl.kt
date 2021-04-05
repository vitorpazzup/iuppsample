package com.itau.infrastructure.service

import com.itau.core.model.Events
import com.itau.core.model.EventsInformationDto
import com.itau.core.model.Product
import com.itau.core.ports.ProductServicePort
import com.itau.entrypoint.controller.handler.ProductExceptionHandler
import com.itau.entrypoint.dto.ProductDto
import com.itau.infrastructure.client.ProductClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val client: ProductClient): ProductServicePort {

    val LOG : Logger = LoggerFactory.getLogger(ProductExceptionHandler::class.java)

    override fun sendNats(product: ProductDto): ProductDto {
        val eventsInformation = EventsInformationDto(
            Events.SAVE_PRODUCT,
            Product(1L,product.name,product.price)
        )
        client.send(eventsInformation)
        LOG.info("message successfully sent to the broker {}", eventsInformation.events.event)
        return product
    }
}