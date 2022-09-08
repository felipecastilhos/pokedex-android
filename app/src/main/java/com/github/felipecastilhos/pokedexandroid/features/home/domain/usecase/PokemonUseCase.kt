package com.github.felipecastilhos.pokedexandroid.features.home.domain.usecase

import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.repository.PokemonRepository
import javax.inject.Inject

/**
 * Business rules to pokemons informations
 */
class PokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    /**
     * Retrieve all pokemon data
     */
    suspend fun search(): Result<Pokemon?> {
        return pokemonRepository.search()
    }
}
