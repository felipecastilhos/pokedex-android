package com.github.felipecastilhos.pokedexandroid.features.home.domain.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.commun.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.commun.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.domain.viewmodels.CoroutineViewModel
import com.github.felipecastilhos.pokedexandroid.features.home.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
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
    dispatcherProvider: DispatcherProvider
) :
    CoroutineViewModel(dispatcherProvider) {
    protected val _stateFlow: MutableStateFlow<GetPokemonQuery.GetPokemon?> by lazy {
        MutableStateFlow<GetPokemonQuery.GetPokemon?>(null).apply {
            launchInIoScope {
                searchPokemon()
            }
        }
    }
    val stateFlow: StateFlow<GetPokemonQuery.GetPokemon?> by lazy { _stateFlow.asStateFlow() }

    /**
     * Query pokemon data
     */
    suspend fun searchPokemon(): Flow<GetPokemonQuery.GetPokemon?> {
        viewModelScope.launch {
            LogHandler.d("Searching Dragonite")
            pokemonUseCase.search().collect {
                LogHandler.d("Dragonite located")
                _stateFlow.emit(it)
            }
        }

        return pokemonUseCase.search()
    }
}
