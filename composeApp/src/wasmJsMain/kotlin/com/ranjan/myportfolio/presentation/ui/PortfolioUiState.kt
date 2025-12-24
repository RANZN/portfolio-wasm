package com.ranjan.myportfolio.presentation.ui

import androidx.compose.runtime.Stable
import com.ranjan.myportfolio.data.models.NavigationSection
import com.ranjan.myportfolio.domain.models.PortfolioState


@Stable
data class PortfolioUiState(
    val portfolioState: PortfolioState = PortfolioState(),
    val selectedSection: NavigationSection = NavigationSection.ABOUT,
    val navigationSections: List<NavigationSection> = NavigationSection.entries.toList(),
    val isDarkMode: Boolean = true,
    val isNavigationCollapsed: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)

