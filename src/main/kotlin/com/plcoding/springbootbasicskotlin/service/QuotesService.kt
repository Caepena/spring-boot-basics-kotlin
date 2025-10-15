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

    fun getQuotes(query: String?): List<QuoteDto> {
        return if(query != null) {
            quotesRepository.findByContentContainsIgnoreCase(query).map { it.toDto() }
        } else {
            quotesRepository.findAll().map { it.toDto() }
        }
    }

    fun insertQuote(quote: QuoteDto): QuoteDto {
        return quotesRepository.save(quote.toEntity().apply { this.id = 0 }).toDto()
    }

    fun updateQuote(quote: QuoteDto): QuoteDto {
        return quotesRepository.save(quote.toEntity()).toDto()
    }

    fun deleteQuotes(quoteId: Long) {
        quotesRepository.deleteById(quoteId)
    }
}