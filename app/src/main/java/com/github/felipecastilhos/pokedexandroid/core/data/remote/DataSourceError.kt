package com.github.felipecastilhos.pokedexandroid.core.data.remote

import com.apollographql.apollo.api.Error

/**
 * Data source exception
 * @param messageResource message for the error
 */
sealed class DataSourceError(
    private val messageResource: Any?
) : Exception() {
    /**
     * Unexpected error
     * @param messageResource resource for the message
     */
    class Unexpected(messageResource: Int) : DataSourceError(messageResource)

    /**
     * Server error
     * @param error that occurred
     */
    class Server(error: Error?) : DataSourceError(error)
}
