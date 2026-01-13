package com.ranjan.myportfolio.di

import com.ranjan.myportfolio.data.repository.PortfolioRepositoryImpl
import com.ranjan.myportfolio.data.service.JsonDataService
import com.ranjan.myportfolio.data.service.JsonDataServiceImpl
import com.ranjan.myportfolio.domain.repository.PortfolioRepository
import com.ranjan.myportfolio.presentation.navigation.BrowserNavigationManager
import com.ranjan.myportfolio.presentation.navigation.NavigationManager
import com.ranjan.myportfolio.presentation.viewmodel.PortfolioViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::JsonDataServiceImpl) bind JsonDataService::class
    singleOf(::PortfolioRepositoryImpl) bind PortfolioRepository::class
}

val domainModule = module {
    // Add use cases here when needed
}

val presentationModule = module {
    singleOf(::BrowserNavigationManager) bind NavigationManager::class
    viewModelOf(::PortfolioViewModel)
}

val appModule = listOf(
    dataModule,
    domainModule,
    presentationModule
)