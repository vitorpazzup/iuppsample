package com.itau.controller.handler

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import javax.inject.Singleton;
import com.itau.controller.ProductController
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Produces
@Singleton
@Requires(classes = [ProductException::class, ExceptionHandler::class])
class ProductExceptionHandler : ExceptionHandler<ProductException?, HttpResponse<*>> {

    //TODO log handler
    //TODO steps gradle
    val LOG : Logger = LoggerFactory.getLogger(ProductExceptionHandler::class.java)
    override fun handle(request: HttpRequest<*>, exception: ProductException?): HttpResponse<*> {
        val productError = ProductError(HttpStatus.BAD_REQUEST.toString(),400
            ,"invalid arguments")
        LOG.error("REQUEST: {}", productError)
        return HttpResponse.badRequest(productError)
    }
}