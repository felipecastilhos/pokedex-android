package com.github.felipecastilhos.pokedexandroid

import com.apollographql.apollo.ApolloClient
import com.github.felipecastilhos.pokedexandroid.logs.LogHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object PokedexApolloClient {
    fun build(): ApolloClient? = ApolloClient.builder()
        .serverUrl(Enviroment.Production.graphQlUrl)
        .okHttpClient(buildOkHttpClient())
        .build()

    private fun buildOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(buildLogInterceptor(HttpLoggingInterceptor.Level.BODY))
            .build()

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
