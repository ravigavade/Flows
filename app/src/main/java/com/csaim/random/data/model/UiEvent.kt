package com.csaim.random.data.model

sealed class UiEvent {
    data class Message(val message: String): UiEvent()
    data class Navigation(val route: String): UiEvent()
}