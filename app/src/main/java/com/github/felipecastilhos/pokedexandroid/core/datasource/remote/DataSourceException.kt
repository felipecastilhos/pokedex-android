package com.github.felipecastilhos.pokedexandroid.core.datasource.remote

import com.apollographql.apollo.api.Error

/**
 * Data source exception
 * @param messageResource message for the error
 */
sealed class DataSourceException(
    val messageResource: Any?
) : RuntimeException() {
    /**
     * Unexpected error
     * @param messageResource resource for the message
     */
    class Unexpected(messageResource: Int) : DataSourceException(messageResource)

    /**
     * Server error
     * @param error that occurred
     */
    class Server(error: Error?) : DataSourceException(error)
}
