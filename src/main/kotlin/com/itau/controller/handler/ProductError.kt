package com.itau.controller.handler

data class ProductError(
    val error: String = "",
    val code: Int = 0,
    val message: String = ""
)