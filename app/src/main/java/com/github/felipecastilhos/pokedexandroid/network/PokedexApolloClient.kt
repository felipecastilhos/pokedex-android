package com.github.felipecastilhos.pokedexandroid.network

import com.github.felipecastilhos.pokedexandroid.logs.LogHandler
import okhttp3.logging.HttpLoggingInterceptor

object PokedexApolloClient {
    fun buildLogInterceptor(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger { message -> LogHandler.d(message) }
        val logging = HttpLoggingInterceptor(logger)
        logging.level = level
        return logging
    }
}

sealed class Enviroment(val graphQlUrl: String) {
    object Production : Enviroment("https://graphqlpokemon.favware.tech/")
}
