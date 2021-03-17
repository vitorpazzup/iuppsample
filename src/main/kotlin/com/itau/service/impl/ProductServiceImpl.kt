package com.itau.service.impl

import com.itau.client.ProductClient
import com.itau.controller.handler.ProductExceptionHandler
import com.itau.model.Events
import com.itau.model.EventsInformationDto
import com.itau.model.Product
import com.itau.model.dto.ProductDto
import com.itau.service.ProductService
import io.nats.client.AuthHandler
import io.nats.client.Connection
import io.nats.client.Nats
import io.nats.client.Options
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets
import javax.inject.Singleton

@Singleton
class ProductServiceImpl: ProductService {

    val LOG : Logger = LoggerFactory.getLogger(ProductExceptionHandler::class.java)

    override fun testNats(product: ProductDto): ProductDto {
        val eventsInformation = EventsInformationDto(
            Events.SAVE_PRODUCT,
            Product(1L,product.name,product.price)
        )
        val natsConnect: Connection = Nats
            .connect("nats://nats-user:eyJhbGciOiJSUzI1NiIsImtpZCI6ImQwMjkyYTcxZWQ5OGZkZDNhYTNkZjdjMTZhYTc2ZGVlM2ZhNGEwMzMifQ.eyJhdWQiOlsibmF0czovL25hdHMtY2x1c3Rlci5uYXRzLWlvLnN2YyJdLCJleHAiOjE2MTU5Mzc4NzcsImlhdCI6MTYxNTkzNDI3NywiaXNzIjoiaHR0cHM6Ly9vaWRjLmVrcy5zYS1lYXN0LTEuYW1hem9uYXdzLmNvbS9pZC84RDM5OEI4MDgzOEU4M0VBMTFFMkNFRjRCMzBEMjZFRSIsImt1YmVybmV0ZXMuaW8iOnsibmFtZXNwYWNlIjoibmF0cy1pbyIsInNlY3JldCI6eyJuYW1lIjoibmF0cy11c2VyLW5hdHMtY2x1c3Rlci1ib3VuZC10b2tlbiIsInVpZCI6IjA5MTJlYTM3LWZhZTUtNDM3ZC05NWE1LTUxOGJkYWFjY2MwYiJ9LCJzZXJ2aWNlYWNjb3VudCI6eyJuYW1lIjoibmF0cy11c2VyIiwidWlkIjoiZGNiOGViNzYtMGFiOS00NmU3LTgzYjYtZDBkMmI3OThlNWZhIn19LCJuYmYiOjE2MTU5MzQyNzcsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpuYXRzLWlvOm5hdHMtdXNlciJ9.TSADKjF_vL1aQ3LLfeNxjQGhIUtNDkpNWxnwiyHdl5Q8D8Qrm-a3wG4l-Zurrz5FdQkZpHb-vqnS9TnfX44tFZL4F6ALnRBB3IHm6aEFxJJ_On9XmxxIjEfDKoCs3SA2UKZWFfZ8BKWYdU1QbGsspvkRsIifiaTlJ5PwXWxUIYQNWr0KEBBACBWLWL8mGuZo0QWT1a4229fBimlBefiHsCiSo3pAb1G-uko_8D97-27uM_geH2phstao5XoehqLT8C-g7OtbaKh_IcD9P4sQpBDLSF6PtxxGgWaYxaU41vucgz4uCVcsPalt_wQeaN0C3FsUUjT8F48imuhIvOs_Dg@nats-cluster.nats-io:4222")
        natsConnect.publish("my-products","teste".toByteArray(StandardCharsets.UTF_8))
        natsConnect.close()
        LOG.info("message successfully sent to the broker {}", eventsInformation.events.event)
        return product
    }
}