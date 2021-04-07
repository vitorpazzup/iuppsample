package com.itau.infrastructure.model

import java.math.BigDecimal

data class EventsInformationDto(
    val events: Events = Events.SAVE_PRODUCT,
    val product: ProductEvent = ProductEvent(null,"", BigDecimal.ZERO)
)