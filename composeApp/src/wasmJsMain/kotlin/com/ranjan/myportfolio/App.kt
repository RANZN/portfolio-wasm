package com.ranjan.myportfolio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.viewmodel.PortfolioViewModel
import com.ranjan.myportfolio.presentation.components.navigation.*
import com.ranjan.myportfolio.presentation.screens.*
import com.ranjan.myportfolio.presentation.theme.*
import org.koin.compose.viewmodel.koinViewModel
import kotlinx.browser.document
import kotlinx.browser.window

@Composable
fun App() {
    val viewModel: PortfolioViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val selectedSection by viewModel.selectedSection.collectAsState()
    val navigationSections by viewModel.navigationSections.collectAsState()
    val isDarkMode by viewModel.isDarkMode.collectAsState()

    var isNavigationCollapsed by remember { mutableStateOf(false) }

    // Set document title based on profile name and selected section
    LaunchedEffect(uiState.profile, selectedSection) {
        document.title = "${uiState.profile.name} - ${selectedSection.title} | Portfolio"
    }

    // Update URL when section changes
    LaunchedEffect(selectedSection) {
        if (window.location.hash != "#${selectedSection.title}") {
            window.history.replaceState(null, "", "#${selectedSection.title}")
        }
    }

    MaterialTheme(
        colorScheme = if (isDarkMode) PortfolioDarkColorScheme else PortfolioLightColorScheme
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val isLargeScreen = maxWidth > 1200.dp
            val isMediumScreen = maxWidth > 800.dp

            when {
                uiState.isLoading -> {
                    LoadingScreen()
                }

                uiState.error != null -> {
                    ErrorScreen(
                        error = uiState.error!!,
                        onRetry = { viewModel.refreshData() },
                        onDismiss = { viewModel.clearError() }
                    )
                }

                else -> {
                    if (isLargeScreen) {
                        // Large screen layout with navigation sidebar
                        Row(modifier = Modifier.fillMaxSize()) {
                            NavigationSidebar(
                                profile = uiState.profile,
                                navigationSections = navigationSections,
                                selectedSection = selectedSection,
                                onSectionSelected = { viewModel.selectSection(it) },
                                isCollapsed = isNavigationCollapsed,
                                onToggleCollapse = {
                                    isNavigationCollapsed = !isNavigationCollapsed
                                },
                                isDarkMode = isDarkMode,
                                onToggleDarkMode = { viewModel.toggleDarkMode() },
                                modifier = Modifier.width(if (isNavigationCollapsed) 80.dp else 280.dp)
                            )

                            // Main content
                            MainContent(
                                uiState = uiState,
                                selectedSection = selectedSection,
                                onSectionSelected = { viewModel.selectSection(it) },
                                modifier = Modifier.weight(1f),
                                isLargeScreen = isLargeScreen
                            )
                        }
                    } else {
                        // Small/medium screen layout with top navigation
                        Column(modifier = Modifier.fillMaxSize()) {
                            TopNavigationBar(
                                navigationSections = navigationSections,
                                selectedSection = selectedSection,
                                onSectionSelected = { viewModel.selectSection(it) },
                                isCompact = !isMediumScreen,
                                isDarkMode = isDarkMode,
                                onToggleDarkMode = { viewModel.toggleDarkMode() }
                            )

                            MainContent(
                                uiState = uiState,
                                selectedSection = selectedSection,
                                onSectionSelected = { viewModel.selectSection(it) },
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