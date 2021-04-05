package com.itau.core.model

import com.itau.model.Events
import com.itau.model.Product
import java.math.BigDecimal

data class EventsInformationDto(
    val events: Events = Events.SAVE_PRODUCT,
    val product: Product = Product(null,"", BigDecimal.ZERO)
)