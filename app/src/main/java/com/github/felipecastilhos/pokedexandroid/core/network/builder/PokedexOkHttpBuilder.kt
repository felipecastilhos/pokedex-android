package com.github.felipecastilhos.pokedexandroid.core.network.builder

import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Builds an OkHttp client for the Pokedex Project
 */
object PokedexOkHttpBuilder {
    fun buildOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(buildLogInterceptor(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    /**
     * Builds a log interceptor for the [OkHttpClient] logging the Body messages into the debug [LogHandler]
     */
    private fun buildLogInterceptor(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger { message -> LogHandler.d(message) }
        val logging = HttpLoggingInterceptor(logger)
        logging.level = level
        return logging
    }
}
