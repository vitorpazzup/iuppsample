package com.itau.core.service

import com.itau.core.mapper.ProductConverter
import com.itau.core.model.Product
import com.itau.core.ports.NatsServicePort
import com.itau.core.ports.ProductServicePort
import javax.inject.Singleton

@Singleton
class ProductService(private val service: NatsServicePort): ProductServicePort {
    override fun productMessage(product: Product)=
         ProductConverter.productToProductDto(
            service.sendNats(ProductConverter.productToProductEvent(product)))

}