package com.ranjan.myportfolio.presentation.intent

import com.ranjan.myportfolio.data.models.NavigationSection


sealed class PortfolioIntent {
    data object LoadPortfolioData : PortfolioIntent()
    data object RefreshData : PortfolioIntent()
    data object ClearError : PortfolioIntent()
    data object ToggleDarkMode : PortfolioIntent()
    data class SelectSection(val section: NavigationSection) : PortfolioIntent()
    data class ToggleNavigationCollapse(val isCollapsed: Boolean) : PortfolioIntent()
}

