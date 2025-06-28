package com.ranjan.myportfolio.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.domain.models.PortfolioState
import com.ranjan.myportfolio.presentation.components.sections.*

@Composable
fun MainContent(
    uiState: PortfolioState,
    selectedSection: String,
    modifier: Modifier = Modifier,
    isLargeScreen: Boolean
) {
    val scrollState = rememberScrollState()
    
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(if (isLargeScreen) 32.dp else 16.dp)
    ) {
        when (selectedSection) {
            "About" -> AboutSection(
                profile = uiState.profile,
                isLargeScreen = isLargeScreen
            )
            "Skills" -> SkillsSection(
                skills = uiState.skills,
                isLargeScreen = isLargeScreen
            )
            "Projects" -> ProjectsSection(
                projects = uiState.projects,
                isLargeScreen = isLargeScreen
            )
            "Articles" -> ArticlesSection(
                articles = uiState.articles,
                isLargeScreen = isLargeScreen
            )
            "Education" -> EducationSection(
                education = uiState.education,
                isLargeScreen = isLargeScreen
            )
            "Contact" -> ContactSection(
                contactInfo = uiState.contactInfo,
                isLargeScreen = isLargeScreen
            )
        }
    }
}