package com.github.felipecastilhos.pokedexandroid.features.home.domain.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.core.viewmodels.CoroutineViewModel
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
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
    protected val _stateFlow: MutableStateFlow<Resource<Pokemon?>> by lazy {
        MutableStateFlow<Resource<Pokemon?>>(Resource.Loading).apply {
            launchInIoScope {
                searchPokemon()
            }
        }
    }
    val stateFlow: StateFlow<Resource<Pokemon?>> by lazy { _stateFlow.asStateFlow() }

    /**
     * Query pokemon data
     */
    suspend fun searchPokemon(): Flow<Resource<Pokemon?>> {
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
