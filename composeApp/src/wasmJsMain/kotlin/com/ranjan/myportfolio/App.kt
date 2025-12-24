package com.ranjan.myportfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.viewmodel.PortfolioViewModel
import com.ranjan.myportfolio.presentation.components.navigation.*
import com.ranjan.myportfolio.presentation.screens.*
import com.ranjan.myportfolio.presentation.ui.theme.PortfolioDarkColorScheme
import com.ranjan.myportfolio.presentation.ui.theme.PortfolioLightColorScheme
import com.ranjan.myportfolio.presentation.ui.components.AnimatedBackground
import com.ranjan.myportfolio.presentation.intent.PortfolioIntent
import org.koin.compose.viewmodel.koinViewModel
import kotlinx.browser.document
import kotlinx.browser.window

@Composable
fun App() {
    val viewModel: PortfolioViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()

    val portfolioState = uiState.portfolioState

    LaunchedEffect(portfolioState.profile.name, uiState.selectedSection) {
        document.title = "${portfolioState.profile.name} | Portfolio"
    }

    LaunchedEffect(uiState.selectedSection) {
        if (window.location.hash != "#${uiState.selectedSection.title}") {
            window.history.replaceState(null, "", "#${uiState.selectedSection.title}")
        }
    }

    MaterialTheme(
        colorScheme = if (uiState.isDarkMode) PortfolioDarkColorScheme else PortfolioLightColorScheme
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            AnimatedBackground(
                modifier = Modifier.fillMaxSize()
            )
            
            val isLargeScreen = maxWidth > 1200.dp
            val isMediumScreen = maxWidth > 800.dp

            when {
                uiState.isLoading -> {
                    LoadingScreen()
                }

                uiState.error != null -> {
                    ErrorScreen(
                        error = uiState.error!!,
                        onRetry = { viewModel.handleIntent(PortfolioIntent.RefreshData) },
                        onDismiss = { viewModel.handleIntent(PortfolioIntent.ClearError) }
                    )
                }

                else -> {
                    if (isLargeScreen) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            NavigationSidebar(
                                profile = portfolioState.profile,
                                navigationSections = uiState.navigationSections,
                                selectedSection = uiState.selectedSection,
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                isCollapsed = uiState.isNavigationCollapsed,
                                onToggleCollapse = {
                                    viewModel.handleIntent(PortfolioIntent.ToggleNavigationCollapse(!uiState.isNavigationCollapsed))
                                },
                                isDarkMode = uiState.isDarkMode,
                                onToggleDarkMode = { viewModel.handleIntent(PortfolioIntent.ToggleDarkMode) },
                                modifier = Modifier.width(if (uiState.isNavigationCollapsed) 80.dp else 280.dp)
                            )

                            MainContent(
                                portfolioState = portfolioState,
                                selectedSection = uiState.selectedSection,
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                modifier = Modifier.weight(1f),
                                isLargeScreen = isLargeScreen
                            )
                        }
                    } else {
                        Column(modifier = Modifier.fillMaxSize()) {
                            TopNavigationBar(
                                navigationSections = uiState.navigationSections,
                                selectedSection = uiState.selectedSection,
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                isCompact = !isMediumScreen,
                                isDarkMode = uiState.isDarkMode,
                                onToggleDarkMode = { viewModel.handleIntent(PortfolioIntent.ToggleDarkMode) }
                            )

                            MainContent(
                                portfolioState = portfolioState,
                                selectedSection = uiState.selectedSection,
                                onSectionSelected = { viewModel.handleIntent(PortfolioIntent.SelectSection(it)) },
                                modifier = Modifier.weight(1f),
                                isLargeScreen = isLargeScreen
                            )
                        }
                    }
                }
            }
        }
    }
}