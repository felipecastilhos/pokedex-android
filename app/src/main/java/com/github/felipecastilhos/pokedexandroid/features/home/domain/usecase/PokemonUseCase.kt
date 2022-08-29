package com.github.felipecastilhos.pokedexandroid.features.home.domain.usecase

import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
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
    suspend fun search(): Resource<Pokemon?> {
        return pokemonRepository.search()
    }
}
