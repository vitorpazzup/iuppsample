package com.itau.infrastructure.service

import com.itau.core.model.Product
import com.itau.core.ports.NatsServicePort
import com.itau.core.service.ProductService
import com.itau.entrypoint.dto.ProductDto
import com.itau.infrastructure.client.ProductClient
import com.itau.infrastructure.model.Events
import com.itau.infrastructure.model.EventsInformationDto
import com.itau.infrastructure.model.ProductEvent
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal

@ExtendWith(MockKExtension::class)
class NatsServiceTest {
    @InjectMockKs
    lateinit var natsService: NatsService

    @MockK
    lateinit var productClient: ProductClient
    lateinit var product: Product
    lateinit var productEvent: ProductEvent
    lateinit var eventsInformationDto: EventsInformationDto
    lateinit var events: Events

    @BeforeEach
    fun setUp(){
        MockKAnnotations.init(this)
        product = Product(1L, "product", BigDecimal.ONE)
        productEvent = ProductEvent(1L, "product", BigDecimal.ONE)
        events = Events.SAVE_PRODUCT
        eventsInformationDto = EventsInformationDto(events,productEvent)
    }

    @Test
    fun `send product with success`(){
        every { productClient.send(any())} returns Unit
        val result = natsService.sendNats(productEvent)
        Assertions.assertEquals(product, result)
    }
}