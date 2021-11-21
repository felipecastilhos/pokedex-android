package com.github.felipecastilhos.pokedexandroid.core.network

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

/**
 * Application builder for [ApolloClient] the abstraction of GraphQl Client
 */
object PokedexApolloBuilder {
    /**
     * Builds an [ApolloClient]
     * @param okHttpClient to be used on [ApolloClient] for making network requests
     * @param apiUrl is the server url to be used on [ApolloClient]
     */
    fun buildApollo(okHttpClient: OkHttpClient, apiUrl: String): ApolloClient =
        ApolloClient.builder()
            .serverUrl(apiUrl)
            .okHttpClient(okHttpClient)
            .build()
}
