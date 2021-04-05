package com.itau.entrypoint.dto

import java.math.BigDecimal

data class ProductDto(
    val id: Long? = null,
    val name: String = "",
    val price: BigDecimal = BigDecimal.ZERO
)