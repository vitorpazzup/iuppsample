package com.itau.client

import com.itau.model.EventsInformationDto
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

import javax.inject.Singleton

@NatsClient
@Singleton
interface ProductClient {
    @Subject("my-products")
    fun send(eventsInformationDto: EventsInformationDto)

    fun sendProduct()
}