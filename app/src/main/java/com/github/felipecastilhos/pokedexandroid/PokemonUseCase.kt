package com.github.felipecastilhos.pokedexandroid

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import javax.inject.Inject

class PokemonUseCase @Inject constructor(private val apolloClient: ApolloClient?) {
    suspend fun search(): GetPokemonQuery.Data? {
        return apolloClient?.query(GetPokemonQuery())?.await()?.data
    }
}
