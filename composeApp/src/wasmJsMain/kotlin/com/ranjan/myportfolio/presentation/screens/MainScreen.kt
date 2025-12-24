package com.ranjan.myportfolio.presentation.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.domain.models.PortfolioState
import com.ranjan.myportfolio.presentation.components.sections.*
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.NavigationSection.*
import com.ranjan.myportfolio.presentation.ui.design.DesignSystem

@Composable
fun MainContent(
    uiState: PortfolioState,
    selectedSection: NavigationSection,
    onSectionSelected: (NavigationSection) -> Unit = {},
    modifier: Modifier = Modifier,
    isLargeScreen: Boolean
) {
    val scrollState = rememberScrollState()

    // Reset scroll position when section changes
    LaunchedEffect(selectedSection) {
        scrollState.scrollTo(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(
                horizontal = if (isLargeScreen) DesignSystem.Spacing.xxl else DesignSystem.Spacing.lg,
                vertical = DesignSystem.Spacing.xl
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Content container with max width for better readability
        Column(
            modifier = Modifier.widthIn(max = DesignSystem.Layout.contentMaxWidth),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.Spacing.xxl)
        ) {
            AnimatedContent(
                targetState = selectedSection,
                transitionSpec = {
                    fadeIn(animationSpec = tween(DesignSystem.Animation.normal)) togetherWith
                            fadeOut(animationSpec = tween(DesignSystem.Animation.normal))
                },
                label = "section_transition"
            ) { section ->
                when (section) {
                ABOUT -> AboutSection(
                    profile = uiState.profile,
                    contactInfo = uiState.contactInfo,
                    skills = uiState.skills,
                    articles = uiState.articles,
                    onSectionSelected = onSectionSelected,
                    isLargeScreen = isLargeScreen
                )
                SKILLS -> SkillsSection(
                    skills = uiState.skills,
                    isLargeScreen = isLargeScreen
                )
                PROJECTS -> ProjectsSection(
                    projects = uiState.projects,
                    isLargeScreen = isLargeScreen
                )
                ARTICLES -> ArticlesSection(
                    articles = uiState.articles,
                    isLargeScreen = isLargeScreen
                )
                EDUCATION -> EducationSection(
                    education = uiState.education,
                    isLargeScreen = isLargeScreen
                )
                    CONTACT -> ContactSection(
                        contactInfo = uiState.contactInfo,
                        isLargeScreen = isLargeScreen
                    )
                }
            }
        }
    }
}