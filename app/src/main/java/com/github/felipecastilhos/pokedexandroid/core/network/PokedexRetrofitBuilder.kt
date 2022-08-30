package com.github.felipecastilhos.pokedexandroid.core.network

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PokedexRetrofitBuilder {

    /**
     * Builds a [Retrofit] client
     * @param okHttpClient to be used on [ApolloClient] for making network requests
     * @param apiUrl is the server url to be used on [ApolloClient]
     */
    fun buildRetrofit(apiUrl: String, okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }
}