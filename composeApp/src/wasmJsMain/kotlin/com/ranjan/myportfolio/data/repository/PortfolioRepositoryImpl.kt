package com.ranjan.myportfolio.data.repository

import com.ranjan.myportfolio.UserData
import com.ranjan.myportfolio.data.models.Article
import com.ranjan.myportfolio.data.models.ContactInfo
import com.ranjan.myportfolio.data.models.Education
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.Profile
import com.ranjan.myportfolio.data.models.Project
import com.ranjan.myportfolio.data.models.Skill
import com.ranjan.myportfolio.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl : PortfolioRepository {

    override suspend fun getProfile(): Profile {
        return Profile(
            name = UserData.NAME,
            title = UserData.JOB_TITLE,
            profileImageRes = UserData.PROFILE,
            aboutDescription = UserData.ABOUT_DESCRIPTION
        )
    }

    override suspend fun getSkills(): List<Skill> = UserData.SKILLS

    override suspend fun getProjects(): List<Project> = UserData.PROJECTS

    override suspend fun getArticles(): List<Article> = UserData.ARTICLES

    override suspend fun getEducation(): List<Education> = UserData.EDUCATION

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