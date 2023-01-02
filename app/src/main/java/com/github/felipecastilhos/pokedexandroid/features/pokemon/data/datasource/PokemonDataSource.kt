package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource

import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonList
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRestService
import kotlinx.coroutines.withContext
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

/**
 * [PokemonDataSource] is an interface for all remote data source queries
 */
interface PokemonDataSource {
    suspend fun pokemonData(): Result<Pokemon>
    suspend fun list(offset: Long, limit: Int): Result<PokemonList>
}

//class PokemonRemoteDataSource @Inject constructor(
////    private val pokemonRestService: PokemonRestService,
//    private val dispatcherProvider: DispatcherProvider
//) : PokemonDataSource {
//    override suspend fun pokemonData(): Result<Pokemon> = withContext(dispatcherProvider.io) {
//        return@withContext pokemonRestService.pokemonData("dragonite")
//    }
//
//    override suspend fun list(offset: Long, limit: Int): Result<PokemonList> =
//        withContext(dispatcherProvider.io) {
//            return@withContext pokemonRestService.list(offset, limit)
//        }
//}

