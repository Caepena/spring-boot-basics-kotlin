package com.plcoding.springbootbasicskotlin.service

import com.plcoding.springbootbasicskotlin.QuoteDto
import com.plcoding.springbootbasicskotlin.QuoteNotFoundException
import com.plcoding.springbootbasicskotlin.repository.QuotesRepository
import org.springframework.stereotype.Service

@Service
class QuotesService(
    private val quotesRepository: QuotesRepository
) {
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