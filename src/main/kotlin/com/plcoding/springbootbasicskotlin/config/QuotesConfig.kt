package com.plcoding.springbootbasicskotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "quotes")
data class QuotesConfig(
    val search: SearchConfig,
    val validation: ValidationConfig
) {
    data class SearchConfig(
        val ignoreCase: Boolean = true,
        val minLength: Int = 3,
    )

    data class ValidationConfig(
        val minContentLength: Int = 5,
        val maxContentLength: Int = 500,
        val requiredAuthor: Boolean = true,
        val allowedCategories: List<String> = emptyList()
    )
}