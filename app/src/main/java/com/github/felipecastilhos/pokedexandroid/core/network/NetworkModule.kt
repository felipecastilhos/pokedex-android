package com.github.felipecastilhos.pokedexandroid.core.network

import com.apollographql.apollo.ApolloClient
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.Enviroment
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.PokemonRestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * This module is responsible to create all network components used in the application
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GraphQlApiUrl

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ApiUrl

    /**
     * Provides the api url
     */
    @GraphQlApiUrl
    @Provides
    fun providePokedexGraphQLApiUrl() = Enviroment.Production.graphQlUrl

    /**
     * Provides the api url
     */
    @ApiUrl
    @Provides
    fun providePokedexApiUrl() = Enviroment.Production.pokeApiUrl

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    /**
     * Provides the OkHttpClient setup
     */
    @Provides
    fun provideOkHttpClient(): OkHttpClient = PokedexOkHttpBuilder.buildOkHttp()

    /**
     * Provides an ApolloClient setup
     * @param okHttpClient to create the network communication
     * @param apiUrl to query
     */

    @Provides
    @Singleton
    fun provideApolloClient(okHttpClient: OkHttpClient, @GraphQlApiUrl graphQlApiUrl: String): ApolloClient =
        PokedexApolloBuilder.buildApollo(okHttpClient = okHttpClient, apiUrl = graphQlApiUrl)


    @Provides
    @Singleton
    fun provideRetrofitClient(
        apiUrl: String,
        @ApiUrl okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit =
        PokedexRetrofitBuilder.buildRetrofit(apiUrl, okHttpClient, moshiConverterFactory)

    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit): PokemonRestService = retrofit.create(PokemonRestService::class.java)

}
