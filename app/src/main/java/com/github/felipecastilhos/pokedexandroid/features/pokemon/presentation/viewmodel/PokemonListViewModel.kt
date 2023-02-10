package com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.viewmodel

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonType
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
class PokemonListViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    val stateFlow: StateFlow<PokemonListUiState> by lazy { _stateFlow.asStateFlow() }

    private val _stateFlow: MutableStateFlow<PokemonListUiState> by lazy {
        MutableStateFlow(PokemonListUiState(isLoading = false)).apply {
            viewModelScope.launch(dispatcherProvider.main) {
                searchPokemon()
            }
        }
    }

    /**
     * Query pokemon data
     */
    suspend fun searchPokemon() {
        LogHandler.d("Searching Dragonite")
        _stateFlow.emit(pokemonUseCase.pokemonList().toView())
    }
}

fun Result<List<Pokemon>>.toView(): PokemonListUiState {
    return if (isSuccess) {
        val pokemonList = getOrNull()
        if (pokemonList == null) {
            PokemonListUiState(isLoading = false, emptyList())
        } else {
            PokemonListUiState(isLoading = false, pokemonList.toUiData())
        }
    } else {
        PokemonListUiState(isLoading = false, pokemons = emptyList())
    }
}

fun List<Pokemon>.toUiData(): List<PokemonListEntryUiData> {
    return this.mapIndexed { index, pokemonListEntry ->
        PokemonListEntryUiData(
            id = index,
            pokedexIndex = pokemonListEntry.pokedexId,
            name = pokemonListEntry.name,
            assetRes = pokemonListEntry.pokemonAsset,
            type = pokemonListEntry.type
        )

    }
}

fun thumbUrl(index: Int) =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/${index + 1}.png"

data class PokemonListUiState(
    val isLoading: Boolean = true,
    val pokemons: List<PokemonListEntryUiData> = emptyList()
)

data class PokemonListEntryUiData(
    val id: Int,
    val pokedexIndex: String,
    val name: String,
    @DrawableRes val assetRes: Int,
    val type: PokemonType
)

