package com.itau.core.ports

import com.itau.core.model.Product
import com.itau.infrastructure.model.ProductEvent
import javax.inject.Singleton

@Singleton
interface NatsServicePort {
    fun sendNats(productEvent: ProductEvent): Product
}