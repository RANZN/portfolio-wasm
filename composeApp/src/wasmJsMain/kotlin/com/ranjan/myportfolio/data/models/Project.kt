package com.ranjan.myportfolio.data.models

data class Project(
    val title: String,
    val description: String,
    val technologies: List<String>,
    val link: String,
    val imageUrl: String? = null
)