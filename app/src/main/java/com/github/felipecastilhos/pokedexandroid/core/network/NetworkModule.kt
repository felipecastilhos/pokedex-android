package com.github.felipecastilhos.pokedexandroid.core.network

import com.apollographql.apollo.ApolloClient
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.Enviroment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * This module is responsible to create all network components used in the application
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    /**
     * Provides the api url
     */
    @Provides
    fun providePokedexApiUrl() = Enviroment.Production.graphQlUrl

    /**
     * Provides the OkHttpClient setup
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = PokedexOkHttpBuilder.buildOkHttp()

    /**
     * Provides an ApolloClient setup
     * @param okHttpClient to create the network communication
     * @param apiUrl to query
     */
    @Provides
    @Singleton
    fun provideApolloClient(okHttpClient: OkHttpClient, apiUrl: String): ApolloClient =
        PokedexApolloBuilder.buildApollo(okHttpClient = okHttpClient, apiUrl = apiUrl)
}
