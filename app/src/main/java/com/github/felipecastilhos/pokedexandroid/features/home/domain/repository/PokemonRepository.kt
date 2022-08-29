package com.github.felipecastilhos.pokedexandroid.features.home.domain.repository

import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import javax.inject.Inject

/**
 * Interface of the pokemon data repository
 */
interface PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    suspend fun search(): Resource<Pokemon?>
}

/**
 * Remote pokemon data repository
 * @param pokemonDataSource for query pokemon data
 */
class DefaultPokemonRemoteDataRepository @Inject constructor(
    private val pokemonDataSource: PokemonDataSource
) :
    PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    override suspend fun search() = pokemonDataSource.search()
}

