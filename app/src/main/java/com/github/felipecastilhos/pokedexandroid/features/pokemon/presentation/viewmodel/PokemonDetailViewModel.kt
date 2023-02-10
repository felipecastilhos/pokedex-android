package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonDetails
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase.PokemonUseCase
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
class PokemonDetailViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    val stateFlow: StateFlow<PokemonDetailsUiState> by lazy { _stateFlow.asStateFlow() }

    private val _stateFlow: MutableStateFlow<PokemonDetailsUiState> by lazy {
        MutableStateFlow(PokemonDetailsUiState(isLoading = false)).apply {
            viewModelScope.launch(dispatcherProvider.main) {
                PokemonDetailsUiState()
            }
        }
    }

    /**
     * Query pokemon data
     */
    suspend fun searchPokemon(index: Int) {
        LogHandler.d("Searching Dragonite")
        _stateFlow.emit(pokemonUseCase.pokemonDetail(index).getOrNull().toUiState())
    }
}

fun PokemonDetails?.toUiState() = PokemonDetailsUiState(isLoading = false, pokemonDetail = this)

data class PokemonDetailsUiState(
    val isLoading: Boolean = true,
    val pokemonDetail: PokemonDetails? = null
)
