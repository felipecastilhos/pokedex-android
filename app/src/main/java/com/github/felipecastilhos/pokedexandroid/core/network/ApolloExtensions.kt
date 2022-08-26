package com.github.felipecastilhos.pokedexandroid.core.network

import com.apollographql.apollo.api.Response
import com.github.felipecastilhos.pokedexandroid.R
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.DataSourceError

/**
 * Maps apollo client response to datasource's resource abstraction
 * @param dataTo is a map to the response data into resource data
 */
fun <T, V> Response<T>?.toResource(dataTo: (T?) -> V): Resource<V?> {
    return when {
        this == null -> {
            Resource.Error(DataSourceError.Unexpected(R.string.server_unexpected_error))
        }
        this.hasErrors() -> {
            Resource.Error(DataSourceError.Server(errors?.first()))
        }
        else -> {
            Resource.Success(dataTo(data))
        }
    }
} 

