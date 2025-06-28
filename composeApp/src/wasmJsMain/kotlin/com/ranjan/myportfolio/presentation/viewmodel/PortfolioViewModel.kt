package com.ranjan.myportfolio.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.ranjan.myportfolio.data.models.*
import com.ranjan.myportfolio.domain.models.PortfolioState
import com.ranjan.myportfolio.domain.repository.PortfolioRepository

class PortfolioViewModel(
    private val repository: PortfolioRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        PortfolioState(
            profile = Profile("", "", "", emptyList()),
            contactInfo = ContactInfo("", "", "", "", null),
            isLoading = true
        )
    )
    val uiState: StateFlow<PortfolioState> = _uiState.asStateFlow()

    private val _selectedSection = MutableStateFlow("About")
    val selectedSection: StateFlow<String> = _selectedSection.asStateFlow()

    private val _navigationSections = MutableStateFlow<List<NavigationSection>>(emptyList())
    val navigationSections: StateFlow<List<NavigationSection>> = _navigationSections.asStateFlow()

    init {
        loadPortfolioData()
    }

    private fun loadPortfolioData() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true, error = null)

                val profile = repository.getProfile()
                val skills = repository.getSkills()
                val projects = repository.getProjects()
                val articles = repository.getArticles()
                val education = repository.getEducation()
                val contactInfo = repository.getContactInfo()
                val navigationSections = repository.getNavigationSections()

                _uiState.value = PortfolioState(
                    profile = profile,
                    skills = skills,
                    projects = projects,
                    articles = articles,
                    education = education,
                    contactInfo = contactInfo,
                    isLoading = false
                )

                _navigationSections.value = navigationSections

            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Failed to load portfolio data: ${e.message}"
                )
            }
        }
    }

    fun selectSection(section: String) {
        _selectedSection.value = section
    }

    fun refreshData() {
        loadPortfolioData()
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

}