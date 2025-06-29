package com.ranjan.myportfolio.data.models

data class ContactInfo(
    val email: String,
    val linkedin: String,
    val github: String,
    val phone: String,
    val twitter: String? = null,
    val medium: String? = null
)