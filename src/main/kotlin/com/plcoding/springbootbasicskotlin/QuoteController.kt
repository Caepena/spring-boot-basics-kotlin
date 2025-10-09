package com.plcoding.springbootbasicskotlin

import com.plcoding.springbootbasicskotlin.service.QuotesService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/quotes")
class QuoteController(
    private val quotesService: QuotesService,
    private val restTemplate: RestTemplate
) {

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