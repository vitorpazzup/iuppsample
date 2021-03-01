package com.itau.controller

import com.itau.controller.handler.ProductException
import com.itau.model.dto.ProductDto
import com.itau.service.ProductService
import com.itau.service.impl.ProductServiceImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockkObject
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
    lateinit var productService: ProductService
    lateinit var product: ProductDto

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        product = ProductDto(1L, "product", BigDecimal.ONE)
    }

    @Test
    fun `request product with success`() {
        every { productService.testNats(any()) } returns product
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
    }

}