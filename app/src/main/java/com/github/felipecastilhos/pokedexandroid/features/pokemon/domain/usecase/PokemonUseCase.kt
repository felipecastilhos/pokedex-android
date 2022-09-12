package com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonList
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonRepository
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
        return pokemonRepository.pokemonData()
    }

    suspend fun list(offset: Long, limit: Int): Result<PokemonList> {
        return pokemonRepository.list(offset, limit)
    }
}
