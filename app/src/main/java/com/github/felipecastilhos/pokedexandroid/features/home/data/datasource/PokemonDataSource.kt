package com.github.felipecastilhos.pokedexandroid.features.home.data.datasource

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.RemoteDataSource
import com.github.felipecastilhos.pokedexandroid.core.network.toResource
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * [PokemonDataSource] is an interface for all remote data source queries
 */
abstract class PokemonDataSource : RemoteDataSource {
    abstract suspend fun search(): Resource<Pokemon?>
}

/**
 * Implementation of [PokemonDataSource] searching in a GraphQl API
 */
class PokemonGraphQlDataSource @Inject constructor(
    private val apolloClient: ApolloClient,
    private val dispatcherProvider: DispatcherProvider
) :
    PokemonDataSource() {

    override suspend fun search(): Resource<Pokemon?> = withContext(dispatcherProvider.io) {
        return@withContext apolloClient.query(GetPokemonQuery())?.await()
            .toResource { it?.getPokemon?.mapToDomainModel() }
    }
}
