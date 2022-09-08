package com.github.felipecastilhos.pokedexandroid.features.home.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Viewmodel to manipulate the pokedex home data
 * @param pokemonUseCase business logic of pokemon data
 * @param dispatcherProvider abstraction of coroutines dispatchers
 */
@HiltViewModel
class PokedexHomeViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _stateFlow: MutableStateFlow<Result<Pokemon?>> by lazy {
        MutableStateFlow<Result<Pokemon?>>(Result.success(null)).apply {
            viewModelScope.launch(dispatcherProvider.main) {
                searchPokemon()
            }
        }
    }
    val stateFlow: StateFlow<Result<Pokemon?>> by lazy { _stateFlow.asStateFlow() }

    /**
     * Query pokemon data
     */
    suspend fun searchPokemon() {
        LogHandler.d("Searching Dragonite")
        _stateFlow.emit(pokemonUseCase.search())
    }
}
