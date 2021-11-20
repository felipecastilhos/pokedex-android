package com.github.felipecastilhos.pokedexandroid.features.home

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val apolloClient: ApolloClient?) {
    suspend fun search(): GetPokemonQuery.Data? {
        return apolloClient?.query(GetPokemonQuery())?.await()?.data
    }
}
