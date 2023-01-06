package com.github.felipecastilhos.pokedexandroid.core.viewmodels.uistate

interface UiState

open class LoadingUiState : UiState {
    val loading: Boolean = true
}

open class RefreshableUiState : UiState {
    val loading: LoadingState = LoadingState.Loading
}

enum class LoadingState {
    Loading,
    Refreshing,
    NotLoading
}