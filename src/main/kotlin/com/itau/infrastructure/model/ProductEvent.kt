package com.itau.infrastructure.model

import java.math.BigDecimal

data class ProductEvent(
    val id: Long? = null,
    val name: String = "",
    val price: BigDecimal = BigDecimal.ZERO
)