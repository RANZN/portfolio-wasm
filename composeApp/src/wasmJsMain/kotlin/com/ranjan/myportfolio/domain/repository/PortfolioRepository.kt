package com.ranjan.myportfolio.domain.repository

import com.ranjan.myportfolio.data.models.*

interface PortfolioRepository {
    suspend fun getProfile(): Profile?
    suspend fun getSkills(): List<Skill>
    suspend fun getProjects(): List<Project>
    suspend fun getArticles(): List<Article>
    suspend fun getEducation(): List<Education>
    suspend fun getContactInfo(): ContactInfo
    suspend fun getNavigationSections(): List<NavigationSection>
}