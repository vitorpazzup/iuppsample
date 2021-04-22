package com.itau.entrypoint.controller

import com.itau.core.ports.ProductServicePort
import com.itau.entrypoint.controller.handler.ProductException
import com.itau.entrypoint.dto.ProductDto
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.math.BigDecimal

@ExtendWith(MockKExtension::class)
class ProductControllerTest {
    @InjectMockKs
    lateinit var producerController: ProductController

    @MockK
    lateinit var productServicePort: ProductServicePort
    lateinit var product: ProductDto

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        product = ProductDto(1L, "product", BigDecimal.ONE)
    }

/*    @Test
    fun `request product with success`() {
        every { productServicePort.productMessage(any()) } returns product
        val result = producerController.saveProduct(product)
        Assertions.assertEquals(product, result)
    }

    @Test
    fun `request product with error in name parameter`(){
            assertThrows<ProductException> {
                producerController.saveProduct(ProductDto(1L,"", BigDecimal.ONE)) }
    }
    @Test
    fun `request product with error in price parameter`(){
        assertThrows<ProductException> {
            producerController.saveProduct(ProductDto(1L,"name")) }
    }*/

}