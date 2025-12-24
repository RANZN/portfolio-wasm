package com.ranjan.myportfolio.domain.models

import com.ranjan.myportfolio.data.models.*

data class PortfolioState(
    val profile: Profile = Profile(),
    val skills: List<Skill> = emptyList(),
    val projects: List<Project> = emptyList(),
    val articles: List<Article> = emptyList(),
    val education: List<Education> = emptyList(),
    val contactInfo: ContactInfo = ContactInfo()
)