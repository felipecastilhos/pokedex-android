package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonList

class FakePokemonDataSource(private val pokemon: Pokemon, private val pokemonList: PokemonList) : PokemonDataSource {
    override suspend fun pokemonData(): Result<Pokemon> {
        return Result.success(pokemon)
    }

    override suspend fun list(offset: Long, limit: Int): Result<PokemonList> {
        return Result.success(pokemonList)
    }
}

class FakeFailingPokemonDataSource : PokemonDataSource {
    override suspend fun pokemonData(): Result<Pokemon> {
        return Result.failure(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }

    override suspend fun list(offset: Long, limit: Int): Result<PokemonList> {
        return Result.failure(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }
}