package com.github.felipecastilhos.pokedexandroid.features.home.data.datasource

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.R
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.DataSourceException
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.RemoteDataSource
import com.github.felipecastilhos.pokedexandroid.core.network.toResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * [HomeRemoteDataSource] is an interface for all remote data source queries
 */
abstract class HomeRemoteDataSource : RemoteDataSource {
    abstract suspend fun search(): Flow<Resource<GetPokemonQuery.GetPokemon?>>
}

/**
 * Implementation of [HomeRemoteDataSource] searching in a GraphQl API
 */
class HomeRemoteGraphQlDataSourceExecutor @Inject constructor(private val apolloClient: ApolloClient) :
    HomeRemoteDataSource() {
    override suspend fun search(): Flow<Resource<GetPokemonQuery.GetPokemon?>> {
        return flow {
            try {
                emit(apolloClient.query(GetPokemonQuery())?.await().toResource { it?.getPokemon })
            } catch (e: Exception) {
                emit(Resource.Error(DataSourceException.Unexpected(R.string.server_no_response)))
            }
        }
    }
}