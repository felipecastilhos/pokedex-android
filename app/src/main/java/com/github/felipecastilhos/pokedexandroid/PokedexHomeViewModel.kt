package com.github.felipecastilhos.pokedexandroid

import androidx.lifecycle.ViewModel

class PokedexHomeViewModel(private val pokemonUseCase: PokemonUseCase) : ViewModel() {
    suspend fun searchPokemon(): GetPokemonQuery.Data? {
        return pokemonUseCase.search()
    }
}
