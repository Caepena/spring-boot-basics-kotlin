package com.plcoding.springbootbasicskotlin.repository

import com.plcoding.springbootbasicskotlin.QuoteDto
import com.plcoding.springbootbasicskotlin.QuoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface QuotesRepository: JpaRepository<QuoteEntity, Long> {
    fun findByContentContainsIgnoreCase(query: String): List<QuoteEntity>

    @Query("""
        SELECT q FROM QuoteEntity q WHERE q.content LIKE '%' || :query || '%'
    """)
    fun searchQuote(query: String): List<QuoteEntity>
}