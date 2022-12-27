package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource

import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonListRemote
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRestService
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * [PokemonDataSource] is an interface for all remote data source queries
 */
interface PokemonDataSource {
    suspend fun pokemonData(): Result<PokemonRemoteData>
    suspend fun list(offset: Long, limit: Int): Result<PokemonListRemote>
}

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonRestService: PokemonRestService,
    private val dispatcherProvider: DispatcherProvider
) : PokemonDataSource {
    override suspend fun pokemonData(): Result<PokemonRemoteData> = withContext(dispatcherProvider.io) {
        return@withContext pokemonRestService.pokemonData("dragonite")
    }

    override suspend fun list(offset: Long, limit: Int): Result<PokemonListRemote> =
        withContext(dispatcherProvider.io) {
            return@withContext pokemonRestService.list(offset, limit)
        }
}

