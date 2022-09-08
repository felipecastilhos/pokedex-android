package com.github.felipecastilhos.pokedexandroid.core.network

import com.github.felipecastilhos.pokedexandroid.core.data.remote.Environment
import com.github.felipecastilhos.pokedexandroid.core.network.builder.PokedexOkHttpBuilder
import com.github.felipecastilhos.pokedexandroid.core.network.builder.PokedexRetrofitBuilder
import com.github.felipecastilhos.pokedexandroid.core.network.resultcall.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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
    fun providePokedexApiUrl() = Environment.Production.pokeApiUrl

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    /**
     * Provides the OkHttpClient setup
     */
    @Provides
    fun provideOkHttpClient(): OkHttpClient = PokedexOkHttpBuilder.buildOkHttp()

    /**
     * Provides the [ResultCallAdapterFactory] setup
     */
    @Provides
    fun providesCallAdapterFactory(): ResultCallAdapterFactory = ResultCallAdapterFactory()

    /**
     * Provides a Retrofit setup
     * @param apiUrl to query
     * @param okHttpClient to create the network communication
     * @param moshiConverterFactory to convert json as object
     * @param resultCallAdapterFactory to handle the retrofit interface response as [Result] object
     */
    @Provides
    @Singleton
    fun provideRetrofitClient(
        apiUrl: String,
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        resultCallAdapterFactory: ResultCallAdapterFactory
    ): Retrofit =
        PokedexRetrofitBuilder.buildRetrofit(
            apiUrl,
            okHttpClient,
            moshiConverterFactory,
            resultCallAdapterFactory
        )
}
