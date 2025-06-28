package com.ranjan.myportfolio.data.models

data class Article(
    val title: String,
    val summary: String,
    val date: String,
    val readTime: String,
    val link: String,
    val tags: List<String> = emptyList()
)