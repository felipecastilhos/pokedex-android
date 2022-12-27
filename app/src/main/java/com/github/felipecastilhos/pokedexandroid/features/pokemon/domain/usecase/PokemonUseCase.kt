package com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonListRemote
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.repository.PokemonRepository
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
    suspend fun search(): Result<PokemonRemoteData?> {
        return pokemonRepository.pokemonData()
    }

    suspend fun list(offset: Long, limit: Int): Result<PokemonListRemote> {
        return pokemonRepository.list(offset, limit)
    }
}
