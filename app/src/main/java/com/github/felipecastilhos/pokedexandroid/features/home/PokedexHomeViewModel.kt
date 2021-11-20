package com.github.felipecastilhos.pokedexandroid.features.home

import com.github.felipecastilhos.pokedexandroid.viewmodels.CoroutineViewModel
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.coroutines.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PokedexHomeViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    dispatcherProvider: DispatcherProvider
) :
    CoroutineViewModel(dispatcherProvider) {
    protected val _stateFlow: MutableStateFlow<GetPokemonQuery.Data?> by lazy {
        MutableStateFlow<GetPokemonQuery.Data?>(null).apply {
            launchInIoScope {
                emit(searchPokemon())
            }
        }
    }

    val stateFlow: StateFlow<GetPokemonQuery.Data?> by lazy { _stateFlow.asStateFlow() }

    suspend fun searchPokemon(): GetPokemonQuery.Data? {
        return pokemonRepository.search()
    }
}
