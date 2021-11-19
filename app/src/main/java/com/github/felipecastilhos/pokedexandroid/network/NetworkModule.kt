package com.github.felipecastilhos.pokedexandroid.network

import com.apollographql.apollo.ApolloClient
import com.github.felipecastilhos.pokedexandroid.Enviroment
import com.github.felipecastilhos.pokedexandroid.PokedexApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(PokedexApolloClient.buildLogInterceptor(HttpLoggingInterceptor.Level.BODY))
        .build()

    /**
     * Provides an ApolloClient setup
     * @param okHttpClient to create the network communication
     * @param apiUrl to query
     */
    @Provides
    @Singleton
    fun provideApolloClient(okHttpClient: OkHttpClient, apiUrl: String): ApolloClient =
        ApolloClient.builder()
            .serverUrl(apiUrl)
            .okHttpClient(okHttpClient)
            .build()
}
