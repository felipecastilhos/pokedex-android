package com.github.felipecastilhos.pokedexandroid.core.network.builder

import com.github.felipecastilhos.pokedexandroid.core.network.resultcall.ResultCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PokedexRetrofitBuilder {

    /**
     * Builds a [Retrofit] client
     * @param okHttpClient to be used on [Retrofit] for making network requests
     * @param apiUrl is the server url to be used on [Retrofit]
     */
    fun buildRetrofit(apiUrl: String, okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory, callAdapterFactory: ResultCallAdapterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
    }
}