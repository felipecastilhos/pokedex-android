package com.github.felipecastilhos.pokedexandroid.features.home.data.datasource

import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

/**
 * [PokemonDataSource] is an interface for all remote data source queries
 */
interface PokemonDataSource {
    suspend fun search(): Result<Pokemon>
}

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonRestService: PokemonRestService,
    private val dispatcherProvider: DispatcherProvider
) : PokemonDataSource {
    override suspend fun search(): Result<Pokemon> = withContext(dispatcherProvider.io) {
        return@withContext pokemonRestService.pokemonData("dragonite")
    }
}

interface PokemonRestService {
    @GET("pokemon/{pokemonName}")
    suspend fun pokemonData(@Path("pokemonName") pokemonName: String): Result<Pokemon>
}