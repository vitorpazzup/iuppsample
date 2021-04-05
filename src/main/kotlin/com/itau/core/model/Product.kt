package com.itau.core.model

import java.math.BigDecimal

data class Product (
    val id: Long? = null,
    val name: String = "",
    val price: BigDecimal = BigDecimal.ZERO
)