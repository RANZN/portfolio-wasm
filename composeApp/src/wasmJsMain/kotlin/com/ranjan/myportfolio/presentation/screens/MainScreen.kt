package com.ranjan.myportfolio.presentation.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ranjan.myportfolio.domain.models.PortfolioState
import com.ranjan.myportfolio.presentation.components.sections.*
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.data.models.NavigationSection.*
import com.ranjan.myportfolio.presentation.ui.design.DesignSystem

@Composable
fun MainContent(
    portfolioState: PortfolioState,
    selectedSection: NavigationSection,
    onSectionSelected: (NavigationSection) -> Unit = {},
    onClick: (String) -> Unit = {},
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
                    profile = portfolioState.profile,
                    contactInfo = portfolioState.contactInfo,
                    skills = portfolioState.skills,
                    articles = portfolioState.articles,
                    onSectionSelected = onSectionSelected,
                    onClick = onClick,
                    isLargeScreen = isLargeScreen
                )
                SKILLS -> SkillsSection(
                    skills = portfolioState.skills,
                    isLargeScreen = isLargeScreen
                )
                PROJECTS -> ProjectsSection(
                    projects = portfolioState.projects,
                    onClick = onClick,
                    isLargeScreen = isLargeScreen
                )
                ARTICLES -> ArticlesSection(
                    articles = portfolioState.articles,
                    onClick = onClick,
                )
                EDUCATION -> EducationSection(
                    education = portfolioState.education,
                    isLargeScreen = isLargeScreen
                )
                    CONTACT -> ContactSection(
                        contactInfo = portfolioState.contactInfo,
                        onClick = onClick,
                        isLargeScreen = isLargeScreen
                    )
                }
            }
        }
    }
}