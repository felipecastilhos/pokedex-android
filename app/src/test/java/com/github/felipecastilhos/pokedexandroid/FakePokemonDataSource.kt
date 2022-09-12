package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource

class FakePokemonDataSource(private val pokemon: Pokemon) : PokemonDataSource {
    override suspend fun pokemonData(): Result<Pokemon> {
        return Result.success(pokemon)
    }
}

class FakeFailingPokemonDataSource : PokemonDataSource {
    override suspend fun pokemonData(): Result<Pokemon> {
        return Result.failure(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }
}