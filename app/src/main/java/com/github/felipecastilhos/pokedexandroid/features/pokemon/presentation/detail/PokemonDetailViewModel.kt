package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.list.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.PokemonDestinationsArgs
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.core.orZero
import com.github.felipecastilhos.pokedexandroid.core.viewmodels.CoroutineViewModel
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonDetails
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PokemonDetailsUiState(
    val isLoading: Boolean = true,
    val pokemonDetail: PokemonDetails? = null
)

/**
 * Viewmodel to manipulate the pokedex home data
 * @param pokemonUseCase business logic of pokemon data
 * @param dispatcherProvider abstraction of coroutines dispatchers
 */
@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
    private val dispatcherProvider: DispatcherProvider,
    savedStateHandle: SavedStateHandle
) : CoroutineViewModel(dispatcherProvider) {
    var index by mutableStateOf(0)

    val state: StateFlow<PokemonDetailsUiState> by lazy { _state.asStateFlow() }

    private val _state: MutableStateFlow<PokemonDetailsUiState> by lazy {
        MutableStateFlow(PokemonDetailsUiState(isLoading = false)).apply {
            viewModelScope.launch(dispatcherProvider.main) {
                PokemonDetailsUiState()
            }
        }
    }

    init {
        index = savedStateHandle.get<String>(PokemonDestinationsArgs.POKEMON_DETAIL_ID_ARG)?.toInt().orZero()
        searchPokemon(index)
    }

    /**
     * Query pokemon data
     */
    fun searchPokemon(index: Int) {
        launchInIoScope {
            LogHandler.d("Searching Dragonite")
            _state.emit(pokemonUseCase.pokemonDetail(index).getOrNull().toUiState())
        }
    }
}

fun PokemonDetails?.toUiState() = PokemonDetailsUiState(isLoading = false, pokemonDetail = this)


