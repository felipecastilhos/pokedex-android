package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.source

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.source.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.source.models.PokemonList

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

