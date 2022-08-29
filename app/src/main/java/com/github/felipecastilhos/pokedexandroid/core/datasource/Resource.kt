package com.github.felipecastilhos.pokedexandroid.core.datasource

import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.DataSourceError

/**
 * Resource is an abstraction for data fetch
 */
sealed class Resource<out T> {
    /**
     * Resource data fetch was successful
     * @param data was the result of data fetch
     */
    data class Success<out T>(val data: T) : Resource<T>()

    /**
     * Resource data fetch didn't work
     * @param exception was the error that occurred fetching data
     */
    data class Error(val exception: DataSourceError) : Resource<Nothing>()

    /**
     * Resource is loading, none result was returned yet.
     */
    object Loading : Resource<Nothing>()
}

/**
 * Extension to handle resouce on success data fetch
 */
inline fun <T : Any> Resource<T>.onSuccess(action: (T) -> Unit): Resource<T> {
    if (this is Resource.Success) action(data)
    return this
}

/**
 * Extension to handle resouce on error data fetch
 */
inline fun <T : Any> Resource<T>.onError(action: (DataSourceError) -> Unit): Resource<T> {
    if (this is Resource.Error) action(exception)
    return this
}

/**
 * Extension to handle resouce when is loading
 */
inline fun <T : Any> Resource<T>.onLoading(action: () -> Unit): Resource<T> {
    if (this is Resource.Loading) action()
    return this
}
