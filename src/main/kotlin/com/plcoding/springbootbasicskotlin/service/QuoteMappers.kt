package com.plcoding.springbootbasicskotlin.service

import com.plcoding.springbootbasicskotlin.QuoteDto
import com.plcoding.springbootbasicskotlin.QuoteEntity

fun QuoteEntity.toDto(): QuoteDto {
    return QuoteDto(
        id = this.id,
        author = this.author,
        content = this.content,
    )
}

fun QuoteDto.toEntity(): QuoteEntity {
    return QuoteEntity(
        id = this.id,
        author = this.author,
        content = this.content
    )
}