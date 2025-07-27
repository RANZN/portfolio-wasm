package com.ranjan.myportfolio.data.models

import com.ranjan.myportfolio.UserData

data class ContactInfo(
    val email: String = UserData.EMAIL,
    val linkedin: String = UserData.LINKEDIN,
    val github: String = UserData.GITHUB,
    val phone: String = UserData.CONTACT,
    val twitter: String? = null,
    val medium: String? = null
)