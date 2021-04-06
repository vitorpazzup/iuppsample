package com.itau.infrastructure.model

import com.itau.core.model.Product
import java.math.BigDecimal

data class EventsInformationDto(
    val events: Events = Events.SAVE_PRODUCT,
    val product: Product = Product(null,"", BigDecimal.ZERO)
)