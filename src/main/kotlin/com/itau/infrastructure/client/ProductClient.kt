package com.itau.infrastructure.client

import com.itau.infrastructure.model.EventsInformationDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import javax.inject.Singleton

@NatsClient
@Singleton
interface ProductClient {
    @Subject("platform.products")
    fun send(eventsInformationDto: EventsInformationDto)
}