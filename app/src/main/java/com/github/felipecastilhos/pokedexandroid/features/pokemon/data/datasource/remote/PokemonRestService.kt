package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonRestService {
    @GET("pokemon/{pokemonName}")
    suspend fun pokemonData(@Path("pokemonName") pokemonName: String): Result<Pokemon>

    @GET("pokemon")
    suspend fun list(
        @Query("offset") offset: Long,
        @Query("limit") limit: Int
    ): Result<PokemonList>
}