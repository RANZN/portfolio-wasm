package com.ranjan.myportfolio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranjan.myportfolio.presentation.viewmodel.PortfolioViewModel
import com.ranjan.myportfolio.presentation.components.navigation.*
import com.ranjan.myportfolio.presentation.screens.*
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val viewModel: PortfolioViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val selectedSection by viewModel.selectedSection.collectAsState()
    val navigationSections by viewModel.navigationSections.collectAsState()
    
    MaterialTheme {
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
                        // Desktop layout with sidebar
                        Row(modifier = Modifier.fillMaxSize()) {
                            NavigationSidebar(
                                profile = uiState.profile,
                                navigationSections = navigationSections,
                                selectedSection = selectedSection,
                                onSectionSelected = { viewModel.selectSection(it) },
                                modifier = Modifier.width(280.dp)
                            )
                            MainContent(
                                uiState = uiState,
                                selectedSection = selectedSection,
                                modifier = Modifier.weight(1f),
                                isLargeScreen = true
                            )
                        }
                    } else {
                        // Mobile/Tablet layout with top navigation
                        Column(modifier = Modifier.fillMaxSize()) {
                            TopNavigationBar(
                                navigationSections = navigationSections,
                                selectedSection = selectedSection,
                                onSectionSelected = { viewModel.selectSection(it) },
                                isCompact = !isMediumScreen
                            )
                            MainContent(
                                uiState = uiState,
                                selectedSection = selectedSection,
                                modifier = Modifier.weight(1f),
                                isLargeScreen = false
                            )
                        }
                    }
                }
            }
        }
    }
}