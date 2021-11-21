package com.github.felipecastilhos.pokedexandroid.features.home.datasource

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.RemoteDataSource
import javax.inject.Inject

/**
 * [HomeRemoteDataSource] is an interface for all remote data source queries
 */
interface HomeRemoteDataSource : RemoteDataSource {
    suspend fun search(): GetPokemonQuery.Data?
}

/**
 * Implementation of [HomeRemoteDataSource] searching in a GraphQl API
 */
class HomeRemoteGraphQlDataSourceImpl @Inject constructor(private val apolloClient: ApolloClient) :
    HomeRemoteDataSource {
    override suspend fun search(): GetPokemonQuery.Data? {
        return apolloClient.query(GetPokemonQuery())?.await()?.data
    }
}
