package com.github.felipecastilhos.pokedexandroid

import com.apollographql.apollo.coroutines.await

class PokemonUseCase() {
    suspend fun search(): GetPokemonQuery.Data? {
        val apolloClient = PokedexApolloClient.build()
        return apolloClient?.query(GetPokemonQuery())?.await()?.data
    }
}
