package com.ranjan.myportfolio.data.repository

import compose.icons.FeatherIcons
import compose.icons.feathericons.*
import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.domain.repository.PortfolioRepository

class PortfolioRepositoryImpl : PortfolioRepository {

    override suspend fun getProfile(): Profile {
        return Profile(
            name = "John Developer",
            title = "Full Stack Developer",
            profileImageRes = "compose_multiplatform",
            aboutDescription = listOf(
                "Hello! I'm a passionate full-stack developer with expertise in modern web and mobile technologies. I love creating efficient, scalable solutions and sharing knowledge with the developer community.",
                "With over 5 years of experience, I specialize in Kotlin, JavaScript, React, and cloud technologies. I'm always eager to learn new technologies and tackle challenging problems."
            )
        )
    }

    override suspend fun getSkills(): List<Skill> {
        return listOf(
            Skill("Kotlin", 0.9f, FeatherIcons.Tool),
            Skill("JavaScript", 0.85f, FeatherIcons.Globe),
            Skill("React", 0.8f, FeatherIcons.Monitor),
            Skill("Node.js", 0.75f, FeatherIcons.Database),
            Skill("Docker", 0.7f, FeatherIcons.Cloud),
            Skill("AWS", 0.65f, FeatherIcons.CloudSnow)
        )
    }

    override suspend fun getProjects(): List<Project> {
        return listOf(
            Project(
                title = "E-commerce Platform",
                description = "Full-stack e-commerce solution with React frontend and Node.js backend",
                technologies = listOf("React", "Node.js", "MongoDB", "Stripe"),
                link = "https://github.com/example/ecommerce"
            ),
            Project(
                title = "Mobile Task Manager",
                description = "Cross-platform mobile app built with Kotlin Multiplatform",
                technologies = listOf("Kotlin", "Compose Multiplatform", "SQLite"),
                link = "https://github.com/example/taskmanager"
            ),
            Project(
                title = "Analytics Dashboard",
                description = "Real-time analytics dashboard with data visualization",
                technologies = listOf("Vue.js", "D3.js", "Python", "FastAPI"),
                link = "https://github.com/example/analytics"
            )
        )
    }

    override suspend fun getArticles(): List<Article> {
        return listOf(
            Article(
                title = "Getting Started with Kotlin Multiplatform",
                summary = "A comprehensive guide to building cross-platform applications with Kotlin Multiplatform Mobile",
                date = "Dec 15, 2023",
                readTime = "8 min read",
                link = "https://medium.com/@example/kotlin-multiplatform",
                tags = listOf("Kotlin", "Mobile", "Cross-platform")
            ),
            Article(
                title = "Modern State Management in React",
                summary = "Exploring the latest patterns and best practices for managing state in React applications",
                date = "Nov 28, 2023",
                readTime = "6 min read",
                link = "https://dev.to/example/react-state-management",
                tags = listOf("React", "JavaScript", "State Management")
            ),
            Article(
                title = "Building Scalable APIs with FastAPI",
                summary = "Learn how to create high-performance APIs using Python's FastAPI framework",
                date = "Oct 10, 2023",
                readTime = "10 min read",
                link = "https://hashnode.com/@example/fastapi-guide",
                tags = listOf("Python", "API", "FastAPI")
            )
        )
    }

    override suspend fun getEducation(): List<Education> {
        return listOf(
            Education(
                degree = "Master of Computer Science",
                institution = "Stanford University",
                year = "2018-2020",
                description = "Specialized in Software Engineering and Machine Learning",
                gpa = "3.9/4.0"
            ),
            Education(
                degree = "Bachelor of Computer Engineering",
                institution = "University of California, Berkeley",
                year = "2014-2018",
                description = "Graduated Magna Cum Laude with focus on Systems Programming",
                gpa = "3.8/4.0"
            )
        )
    }

    override suspend fun getContactInfo(): ContactInfo {
        return ContactInfo(
            email = "john@example.com",
            linkedin = "https://linkedin.com/in/johndeveloper",
            github = "https://github.com/johndeveloper",
            twitter = "https://twitter.com/johndeveloper",
            phone = "+1 (555) 123-4567"
        )
    }

    override suspend fun getNavigationSections(): List<NavigationSection> {
        return listOf(
            NavigationSection("About", FeatherIcons.User),
            NavigationSection("Skills", FeatherIcons.Star),
            NavigationSection("Projects", FeatherIcons.Briefcase),
            NavigationSection("Articles", FeatherIcons.FileText),
            NavigationSection("Education", FeatherIcons.BookOpen),
            NavigationSection("Contact", FeatherIcons.Mail)
        )
    }
}