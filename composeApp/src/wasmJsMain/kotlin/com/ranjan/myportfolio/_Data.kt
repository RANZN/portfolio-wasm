package com.ranjan.myportfolio

import com.ranjan.myportfolio.data.models.*
import compose.icons.SimpleIcons
import compose.icons.simpleicons.*
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.compose_multiplatform

object UserData {
    val PROFILE = Res.drawable.compose_multiplatform
    const val NAME = "Prakash Ranjan"
    const val JOB_TITLE = "Senior Android Developer\nCompose Multiplatform Developer"
    const val EMAIL = "prakashranjan2803@gmail.com"
    const val CONTACT = "+91 7319886550"
    const val LINKEDIN = "https://linkedin.com/in/prakash-ranzan"
    const val GITHUB = "https://github.com/RANZN"
    const val TWITTER = "https://twitter.com/prakashranjan"
    const val MEDIUM = "https://medium.com/@prakash_ranjan"

    val ABOUT_DESCRIPTION = listOf(
        "Highly motivated Senior Android Developer with expertise in developing, testing, and deploying Android applications. Currently working at Evangelist Apps, specializing in Kotlin Multiplatform and Jetpack Compose technologies.",
        "I possess strong analytical and problem-solving skills with a solid understanding of mobile app development. Skilled in Java, Kotlin, Android Studio, and SQLite, along with code versioning using GitHub and Bitbucket, following Agile Scrum methodology for product development."
    )

    val SKILLS = listOf(
        Skill("Kotlin", 0.9f, SimpleIcons.Kotlin),
        Skill("Kotlin Multiplatform", 0.85f, SimpleIcons.Kotlin),
        Skill("Jetpack Compose", 0.85f, SimpleIcons.Kotlin),
        Skill("Android", 0.9f, SimpleIcons.Android),
        Skill("Android Studio", 0.85f, SimpleIcons.Androidstudio),
        Skill("Java", 0.8f, SimpleIcons.Java),
        Skill("SQLite", 0.75f, SimpleIcons.Sqlite),
        Skill("Git", 0.8f, SimpleIcons.Git),
        Skill("GitHub", 0.8f, SimpleIcons.Github),
        Skill("Bitbucket", 0.75f, SimpleIcons.Bitbucket),
        Skill("Firebase", 0.7f, SimpleIcons.Firebase)
    )

    val PROJECTS = listOf(
        Project(
            title = "MyPortfolio",
            description = "Personal portfolio website built with Kotlin Multiplatform and Compose for Web, showcasing modern cross-platform development",
            technologies = listOf("Kotlin Multiplatform", "Compose Multiplatform", "WASM", "Web"),
            link = "https://github.com/RANZN/MyPortfolio"
        ),
        Project(
            title = "SmartCents",
            description = "Personal finance management app with expense tracking and budget management using modern Android architecture",
            technologies = listOf("Kotlin", "Android", "Room", "MVVM", "Material Design", "Jetpack Compose"),
            link = "https://github.com/RANZN/SmartCents"
        ),
        Project(
            title = "Forum Mobile Android",
            description = "Mobile forum application with real-time messaging and community features built with modern Android stack",
            technologies = listOf("Kotlin", "Android", "Firebase", "Material Design", "Real-time", "Jetpack Compose"),
            link = "https://github.com/RANZN/forum-mobile-android"
        ),
        Project(
            title = "Evangelist Apps Projects",
            description = "Professional Android applications developed at Evangelist Apps using cutting-edge technologies",
            technologies = listOf("Kotlin", "Android", "Kotlin Multiplatform", "Jetpack Compose"),
            link = "https://github.com/RANZN"
        )
    )

    val ARTICLES = listOf(
        Article(
            title = "Kotlin Multiplatform in Production",
            summary = "Sharing insights from implementing Kotlin Multiplatform in real-world Android applications at Evangelist Apps",
            date = "Jan 20, 2024",
            readTime = "8 min read",
            link = "https://medium.com/@prakash_ranjan/kotlin-multiplatform-production",
            tags = listOf("Kotlin Multiplatform", "Android", "Production")
        ),
        Article(
            title = "Modern Android Development with Jetpack Compose",
            summary = "Best practices and patterns for building scalable Android apps with Jetpack Compose",
            date = "Dec 15, 2023",
            readTime = "10 min read",
            link = "https://medium.com/@prakash_ranjan/jetpack-compose-modern-android",
            tags = listOf("Jetpack Compose", "Android", "UI Development")
        ),
        Article(
            title = "Agile Development in Mobile Teams",
            summary = "Implementing Agile Scrum methodology effectively in Android development teams",
            date = "Nov 28, 2023",
            readTime = "6 min read",
            link = "https://medium.com/@prakash_ranjan/agile-mobile-development",
            tags = listOf("Agile", "Scrum", "Team Management")
        )
    )

    val EDUCATION = listOf(
        Education(
            degree = "Bachelor of Technology - BTech",
            institution = "KIIT - Kalinga Institute of Industrial Technology",
            year = "Jan 2017 - Jan 2021",
            description = "Electrical and Electronics Engineering with focus on software development and mobile technologies",
            gpa = "8.02"
        ),
        Education(
            degree = "Professional Android Development",
            institution = "Evangelist Apps & Continuous Learning",
            year = "Oct 2024 - Present",
            description = "Advanced Android development with Kotlin Multiplatform and Jetpack Compose in production environment",
            gpa = "Professional Experience"
        )
    )
}