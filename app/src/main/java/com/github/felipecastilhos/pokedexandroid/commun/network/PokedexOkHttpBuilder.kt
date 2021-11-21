package com.github.felipecastilhos.pokedexandroid.commun.network

import com.github.felipecastilhos.pokedexandroid.commun.logs.LogHandler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 *
 */
object PokedexOkHttpBuilder {
    fun buildOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(buildLogInterceptor(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    private fun buildLogInterceptor(level: HttpLoggingInterceptor.Level): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger { message -> LogHandler.d(message) }
        val logging = HttpLoggingInterceptor(logger)
        logging.level = level
        return logging
    }
}
