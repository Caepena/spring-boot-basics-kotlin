package com.plcoding.springbootbasicskotlin.repository

import com.plcoding.springbootbasicskotlin.QuoteDto
import org.springframework.stereotype.Repository

@Repository
class QuotesRepository {

    private val quotes = mutableListOf<QuoteDto>()

    fun getQuotes() = quotes

    fun insertQuote(quote: QuoteDto): QuoteDto {
        quotes.add(quote)
        return quote
    }

    fun updateQuote(quote: QuoteDto): QuoteDto {
        val index = quotes.indexOfFirst { it.id == quote.id }
        quotes[index] = quote
        return quote
    }

    fun deleteQuotes(quoteId: Long): Boolean {
        val quoteToDelete = quotes.find { it.id == quoteId }
        return if (quoteToDelete != null) {
            quotes.remove(quoteToDelete)
            true
        } else {
            false
        }
    }
}