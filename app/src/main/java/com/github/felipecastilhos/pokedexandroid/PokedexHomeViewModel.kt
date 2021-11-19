package com.github.felipecastilhos.pokedexandroid

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokedexHomeViewModel @Inject constructor(private val pokemonUseCase: PokemonUseCase) :
    ViewModel() {
    suspend fun searchPokemon(): GetPokemonQuery.Data? {
        return pokemonUseCase.search()
    }
}
