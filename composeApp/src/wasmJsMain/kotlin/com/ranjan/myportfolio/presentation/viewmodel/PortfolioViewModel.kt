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
import kotlinx.browser.window
import kotlinx.coroutines.async

class PortfolioViewModel(
    private val repository: PortfolioRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        PortfolioState(
            profile = Profile("", "", emptyList()),
            skills = emptyList(),
            projects = emptyList(),
            articles = emptyList(),
            education = emptyList(),
            contactInfo = ContactInfo("", "", "", "", "", ""),
            isLoading = true
        )
    )
    val uiState: StateFlow<PortfolioState> = _uiState.asStateFlow()

    private val _selectedSection = MutableStateFlow(NavigationSection.ABOUT)
    val selectedSection: StateFlow<NavigationSection> = _selectedSection.asStateFlow()

    private val _navigationSections = MutableStateFlow(NavigationSection.entries.toList())
    val navigationSections: StateFlow<List<NavigationSection>> = _navigationSections.asStateFlow()

    private val _isDarkMode = MutableStateFlow(true)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    init {
        loadPortfolioData()
        initializeBrowserHistory()
    }

    private fun initializeBrowserHistory() {
        // Get initial section from URL hash
        val initialSection = getSectionFromUrl()
        _selectedSection.value = initialSection

        // Listen for browser back/forward events
        window.addEventListener("popstate") { event ->
            val section = getSectionFromUrl()
            _selectedSection.value = section
        }
    }

    private fun getSectionFromUrl(): NavigationSection {
        val hash = window.location.hash
        return if (hash.startsWith("#")) {
            NavigationSection.fromUrlHash(hash.substring(1))
        } else {
            NavigationSection.ABOUT
        }
    }

    private fun updateUrl(section: NavigationSection) {
        val newUrl = "${window.location.pathname}#${section.title}"
        window.history.pushState(null, "", newUrl)
    }

    private fun loadPortfolioData() {
        viewModelScope.launch {
            try {
                val profileDeferred = async { repository.getProfile() }
                val skillsDeferred = async { repository.getSkills() }
                val projectsDeferred = async { repository.getProjects() }
                val articlesDeferred = async { repository.getArticles() }
                val educationDeferred = async { repository.getEducation() }
                val contactInfoDeferred = async { repository.getContactInfo() }

                val profile = profileDeferred.await()
                val skills = skillsDeferred.await()
                val projects = projectsDeferred.await()
                val articles = articlesDeferred.await()
                val education = educationDeferred.await()
                val contactInfo = contactInfoDeferred.await()

                _uiState.value = PortfolioState(
                    profile = profile,
                    skills = skills,
                    projects = projects,
                    articles = articles,
                    education = education,
                    contactInfo = contactInfo,
                    isLoading = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Failed to load portfolio data: ${e.message}"
                )
            }
        }
    }

    fun selectSection(section: NavigationSection) {
        if (_selectedSection.value != section) {
            _selectedSection.value = section
            updateUrl(section)
        }
    }

    fun toggleDarkMode() {
        _isDarkMode.value = !_isDarkMode.value
    }

    fun refreshData() {
        loadPortfolioData()
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}