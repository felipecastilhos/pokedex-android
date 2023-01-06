package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonList
import javax.inject.Inject

/**
 * Interface of the pokemon data repository
 */
interface PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    suspend fun pokemonData(): Result<Pokemon?>

    /**
     * Paginated list of pokemons
     * @param offset move to another page
     * @param limit of pokemons per page
     */
    suspend fun list(offset: Long, limit: Int): Result<PokemonList>
}

/**
 * Remote pokemon data repository
 * @param pokemonDataSource for query pokemon data
 */
class DefaultPokemonRemoteDataRepository @Inject constructor(
    private val pokemonDataSource: PokemonDataSource
) :
    PokemonRepository {
    /**
     * Query for all data of a single pokemon
     */
    override suspend fun pokemonData() = pokemonDataSource.pokemonData()
    /**
     * Paginated list of pokemons
     * @param offset move to another page
     * @param limit of pokemons per page
     */
    override suspend fun list(offset: Long, limit: Int) = pokemonDataSource.list(offset, limit)
}

