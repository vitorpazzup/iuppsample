package com.itau.service

import com.itau.client.ProductClient
import com.itau.model.Events
import com.itau.model.EventsInformationDto
import com.itau.model.Product
import com.itau.model.dto.ProductDto
import com.itau.service.impl.ProductServiceImpl
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
class ProductServiceImplTest {

    @InjectMockKs
    lateinit var producerServiceImplImpl: ProductServiceImpl

    @MockK
    lateinit var productClient: ProductClient

    lateinit var product: Product
    lateinit var events: Events
    lateinit var eventsInformationDto: EventsInformationDto
    lateinit var productDto: ProductDto

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        productDto = ProductDto(1L, "product", BigDecimal.ONE)
        product = Product(1L, "product", BigDecimal.ONE)
        events = Events.SAVE_PRODUCT
        eventsInformationDto = EventsInformationDto(events, product)
    }

    @Test
    fun `sending event`() {
/*        every { productClient.send(eventsInformationDto) } returns Unit
        val result = producerServiceImplImpl.testNats(productDto)
        Assertions.assertNotNull(result)
    }*/
    }
}