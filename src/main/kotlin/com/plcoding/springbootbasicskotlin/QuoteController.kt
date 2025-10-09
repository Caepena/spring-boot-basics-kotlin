package com.plcoding.springbootbasicskotlin

import com.plcoding.springbootbasicskotlin.service.QuotesService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Component
class Test {
    init {
        println("hello world!")
    }
}

@RestController
@RequestMapping("/quotes")
class QuoteController(
    private val quotesService: QuotesService,
    private val test: Test
) {

    val quotes = mutableListOf<QuoteDto>()

    @GetMapping
    fun loadQuotes(
        @RequestParam("q", required = false) query: String?
    ): List<QuoteDto> {
        return quotesService.getQuotes()
    }

    @PostMapping
    fun postQuote(@RequestBody quoteDto: QuoteDto): QuoteDto {
        return quotesService.insertQuote(quoteDto)
    }

    @PutMapping
    fun putQuote(@RequestBody quoteDto: QuoteDto): QuoteDto {
        return quotesService.updateQuote(quoteDto)
    }

    @DeleteMapping("/{id}")
    fun deleteQuote(@PathVariable("id") id: Long) {
        quotesService.deleteQuotes(id)
    }
}