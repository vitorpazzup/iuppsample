package com.itau.service.impl

import com.itau.client.ProductClient
import com.itau.controller.handler.ProductExceptionHandler
import com.itau.model.Events
import com.itau.model.EventsInformationDto
import com.itau.model.Product
import com.itau.model.dto.ProductDto
import com.itau.service.ProductService
import io.nats.client.AuthHandler
import io.nats.client.Connection
import io.nats.client.Nats
import io.nats.client.Options
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets
import javax.inject.Singleton

@Singleton
class ProductServiceImpl(private val client: ProductClient): ProductService {

    val LOG : Logger = LoggerFactory.getLogger(ProductExceptionHandler::class.java)

    override fun testNats(product: ProductDto): ProductDto {
        val eventsInformation = EventsInformationDto(
            Events.SAVE_PRODUCT,
            Product(1L,product.name,product.price)
        )
        client.send(eventsInformation)
        LOG.info("message successfully sent to the broker {}", eventsInformation.events.event)
        return product
    }
}