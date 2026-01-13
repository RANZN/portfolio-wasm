package com.ranjan.myportfolio.presentation.events

sealed interface UiEvent {
    data class OpenUrl(val url: String) : UiEvent
}