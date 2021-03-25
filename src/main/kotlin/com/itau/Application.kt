package com.itau

import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	ApplicationContext.run()
	build()
	    .args(*args)
		.packages("com.itau")
		.environmentVariableExcludes(Environment.KUBERNETES,Environment.AMAZON_EC2,Environment.CLOUD)
		.environments("dev")
		.start()
}

