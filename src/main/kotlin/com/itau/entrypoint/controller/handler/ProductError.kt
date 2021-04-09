package com.itau.entrypoint.controller.handler

data class ProductError(
    val error: String = "",
    val code: Int = 0,
    val message: String = ""
)