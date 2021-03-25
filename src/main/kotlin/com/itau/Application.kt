package com.itau

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	ApplicationContext.run()
	build()
	    .args(*args)
		.packages("com.itau")
		.environmentVariableExcludes("k8s")
		.environments("dev")
		.start()
}

