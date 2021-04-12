package com.itau.core.service

import com.itau.core.model.Product
import com.itau.core.ports.NatsServicePort
import com.itau.entrypoint.dto.ProductDto
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.lang.AssertionError
import java.math.BigDecimal

@ExtendWith(MockKExtension::class)
class ProductServiceTest {
    @InjectMockKs
    lateinit var productService: ProductService

    @MockK
    lateinit var natsServicePort: NatsServicePort
    lateinit var product:Product
    lateinit var productDto: ProductDto

    @BeforeEach
    fun setUP(){
        MockKAnnotations.init(this)
        product = Product(1L, "product", BigDecimal.ONE)
        productDto = ProductDto(1L,"product", BigDecimal.ONE)
    }

    @Test
    fun `save product with success`(){
        every { natsServicePort.sendNats(any()) } returns product
        val result = productService.productMessage(product)
        Assertions.assertEquals(productDto,result)
    }


}