package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.PokemonDataSource

class FakePokemonDataSource(private val pokemon: Pokemon) : PokemonDataSource() {
    override suspend fun search(): Result<Pokemon> {
        return Result.success(pokemon)
    }
}

class FakeFailingPokemonDataSource : PokemonDataSource() {
    override suspend fun search(): Result<Pokemon> {
        return Result.failure(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }
}