package com.github.felipecastilhos.pokedexandroid.features.home.domain.repository

import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.features.home.datasource.HomeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Interface of the pokemon data repository
 */
interface PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    suspend fun search(): Flow<GetPokemonQuery.GetPokemon?>
}

/**
 * Remote pokemon data repository
 * @param homeRemoteDataSource for query pokemon data
 */
class PokemonRemoteDataRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) :
    PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    override suspend fun search(): Flow<GetPokemonQuery.GetPokemon?> = flow {
        emit(homeRemoteDataSource.search()?.getPokemon)
    }
}
