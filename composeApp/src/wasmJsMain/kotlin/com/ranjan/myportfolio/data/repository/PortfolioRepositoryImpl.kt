package com.ranjan.myportfolio.data.repository

import com.ranjan.myportfolio.UserData
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.data.models.ContactInfo
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.data.models.Project
import com.ranjan.myportfolio.data.models.Skill
import com.ranjan.myportfolio.data.service.JsonDataService
import com.ranjan.myportfolio.data.service.PortfolioJsonData
import com.ranjan.myportfolio.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl(
    private val jsonDataService: JsonDataService
) : PortfolioRepository {
    
    // Cache the loaded JSON data
    private var cachedJsonData: PortfolioJsonData? = null

    override suspend fun getProfile(): Profile {
        return Profile(
            name = UserData.NAME,
            title = UserData.JOB_TITLE,
            profileImageRes = UserData.PROFILE,
            aboutDescription = UserData.ABOUT_DESCRIPTION
        )
    }

    override suspend fun getSkills(): List<Skill> = UserData.SKILLS

    override suspend fun getProjects(): List<Project> {
        val data = loadJsonData()
        return data?.projects ?: emptyList()
    }

    override suspend fun getArticles(): List<Article> {
        val data = loadJsonData()
        return data?.articles ?: emptyList()
    }

    override suspend fun getEducation(): List<Education> {
        val data = loadJsonData()
        return data?.education ?: emptyList()
    }
    
    /**
     * Loads JSON data once and caches it for subsequent calls.
     * Loads from local resources (bundled JSON file).
     * The JSON file is loaded only once per app session.
     */
    private suspend fun loadJsonData(): PortfolioJsonData? {
        if (cachedJsonData == null) {
            cachedJsonData = jsonDataService.loadPortfolioData()
        }
        return cachedJsonData
    }

    override suspend fun getContactInfo(): ContactInfo {
        return ContactInfo(
            email = UserData.EMAIL,
            linkedin = UserData.LINKEDIN,
            github = UserData.GITHUB,
            twitter = UserData.TWITTER,
            phone = UserData.CONTACT,
            medium = UserData.MEDIUM
        )
    }

    override suspend fun getNavigationSections(): List<NavigationSection> {
        return NavigationSection.entries
    }
}