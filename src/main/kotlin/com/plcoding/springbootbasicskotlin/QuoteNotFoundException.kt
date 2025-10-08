package com.plcoding.springbootbasicskotlin

class QuoteNotFoundException(private val id: Long): RuntimeException(
    "A quote if ID $id not found"
)