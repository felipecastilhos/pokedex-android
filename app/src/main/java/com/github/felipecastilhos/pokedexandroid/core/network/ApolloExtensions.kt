package com.github.felipecastilhos.pokedexandroid.core.network

import com.apollographql.apollo.api.Response
import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.DataSourceException

/**
 * Maps apollo client response to datasource's resource abstraction
 * @param dataTo is a map to the response data into resource data
 */
fun <T, R> Response<T>?.toResource(dataTo: (T?) -> R): Resource<R?> {
    return try {
        if (this == null) {
            Resource.Error(DataSourceException.Unexpected("houve algo errado"))
        }
        if (this == null || this.hasErrors()) {
            if (this == null) Resource.Error(DataSourceException.Unexpected("sem response"))
            else Resource.Error(DataSourceException.Server(errors?.first()))
        } else {
            Resource.Success(dataTo(data))
        }
    } catch (e: Exception) {
        Resource.Error(DataSourceException.Unexpected("houve algo errado"))
    }
}
