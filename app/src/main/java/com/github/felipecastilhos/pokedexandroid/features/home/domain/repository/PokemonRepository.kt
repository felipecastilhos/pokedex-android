package com.github.felipecastilhos.pokedexandroid.features.home.domain.repository

import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Interface of the pokemon data repository
 */
interface PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    suspend fun search(): Flow<Resource<GetPokemonQuery.GetPokemon?>>
}

/**
 * Remote pokemon data repository
 * @param homeRemoteDataSource for query pokemon data
 */
class PokemonRemoteDataRepositoryExecutor @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) :
    PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    override suspend fun search(): Flow<Resource<GetPokemonQuery.GetPokemon?>> =
        homeRemoteDataSource.search()
}
