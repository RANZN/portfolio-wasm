package com.ranjan.myportfolio.data.models

data class Profile(
    val name: String,
    val title: String,
    val profileImageRes: String,
    val aboutDescription: List<String>
)