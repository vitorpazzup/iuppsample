package com.itau.client

import com.itau.model.EventsInformationDto

import javax.inject.Singleton

//@NatsClient
@Singleton
interface ProductClient {
  //  @Subject("my-products")
    fun send(eventsInformationDto: EventsInformationDto)

    fun sendProduct()
}