package com.ranjan.myportfolio.di

import com.ranjan.myportfolio.data.repository.PortfolioRepositoryImpl
import com.ranjan.myportfolio.domain.repository.PortfolioRepository
import com.ranjan.myportfolio.presentation.navigation.BrowserNavigationManager
import com.ranjan.myportfolio.presentation.navigation.NavigationManager
import com.ranjan.myportfolio.presentation.viewmodel.PortfolioViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<PortfolioRepository> { PortfolioRepositoryImpl() }
}

val domainModule = module {
    // Add use cases here when needed
}

val presentationModule = module {
    single<NavigationManager> { BrowserNavigationManager() }
    viewModel { PortfolioViewModel(get(), get()) }
}

val appModule = listOf(
    dataModule,
    domainModule,
    presentationModule
)