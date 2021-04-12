package com.itau

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.Micronaut.build
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
	info = Info(
		title = "IUPP Product",
		version = "0.1",
		description = "IUPP Sample",
		license = License(name = "Apache 2.0", url = "https://foo.bar"),
		contact = Contact(url = "https://www.iupp.com.br/", name = "IUPP", email = "IUPP@IUPP.com")
	)
)
object Api {
}
fun main(args: Array<String>) {
	ApplicationContext.run()
	build()
	    .args(*args)
		.packages("com.itau")
		.environments("dev")
		.start()
}

