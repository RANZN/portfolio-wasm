package com.ranjan.myportfolio.data.models

data class Education(
    val degree: String,
    val institution: String,
    val year: String,
    val description: String,
    val gpa: String? = null
)