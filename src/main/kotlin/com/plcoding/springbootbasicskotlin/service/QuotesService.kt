package com.plcoding.springbootbasicskotlin.service

import com.plcoding.springbootbasicskotlin.QuoteDto
import com.plcoding.springbootbasicskotlin.QuoteNotFoundException
import com.plcoding.springbootbasicskotlin.config.QuotesConfig
import com.plcoding.springbootbasicskotlin.repository.QuotesRepository
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class QuotesService(
    private val quotesRepository: QuotesRepository,
    private val quotesConfig: QuotesConfig
) {

    init {
        println(quotesConfig)
    }

    fun getQuotes() = quotesRepository.getQuotes()

    fun insertQuote(quote: QuoteDto): QuoteDto {
        return quotesRepository.insertQuote(quote)
    }

    fun updateQuote(quote: QuoteDto): QuoteDto {
        return quotesRepository.updateQuote(quote)
    }

    fun deleteQuotes(quoteId: Long) {
        if (!quotesRepository.deleteQuotes(quoteId)) {
            throw QuoteNotFoundException(quoteId)
        }
    }
}