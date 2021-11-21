package com.github.felipecastilhos.pokedexandroid.features.home.domain.repository

import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.HomeRemoteDataSource
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Interface of the pokemon data repository
 */
interface PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    suspend fun search(): Flow<Resource<Pokemon?>>
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
    override suspend fun search(): Flow<Resource<Pokemon?>> =
        homeRemoteDataSource.search().mapToDomainFlow()
}

fun Flow<Resource<GetPokemonQuery.GetPokemon?>>.mapToDomainFlow(): Flow<Resource<Pokemon?>> {
    return map {
        when (it) {
            is Resource.Error -> it
            Resource.Loading -> Resource.Loading
            is Resource.Success -> Resource.Success(it.data?.mapToDomainModel())
        }
    }
}
