package com.itau.infrastructure.service

import com.itau.core.mapper.ProductConverter
import com.itau.core.model.Product
import com.itau.core.ports.NatsServicePort
import com.itau.entrypoint.controller.handler.ProductExceptionHandler
import com.itau.infrastructure.client.ProductClient
import com.itau.infrastructure.model.Events
import com.itau.infrastructure.model.EventsInformationDto
import com.itau.infrastructure.model.ProductEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class NatsService(private val client: ProductClient): NatsServicePort {

    val LOG : Logger = LoggerFactory.getLogger(ProductExceptionHandler::class.java)

    override fun sendNats(productEvent: ProductEvent): Product {
        val eventsInformation = EventsInformationDto(
            Events.SAVE_PRODUCT,
            ProductEvent(1L,productEvent.name,productEvent.price)
        )
        client.send(eventsInformation)
        LOG.info("message successfully sent to the broker {}", eventsInformation.events.event)
        return ProductConverter.productEventToProduct(productEvent)
    }
}