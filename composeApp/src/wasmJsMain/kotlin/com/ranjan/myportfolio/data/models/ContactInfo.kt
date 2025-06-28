package com.ranjan.myportfolio.data.models

data class ContactInfo(
    val email: String,
    val linkedin: String,
    val github: String,
    val twitter: String,
    val phone: String? = null,
    val medium: String? = null
)