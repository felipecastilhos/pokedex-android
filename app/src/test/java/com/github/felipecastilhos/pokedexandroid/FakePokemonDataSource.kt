package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.core.datasource.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon

class FakePokemonDataSource(private val pokemon: Pokemon): PokemonDataSource() {
    override suspend fun search(): Resource<Pokemon> {
        return  Resource.Success(pokemon)
    }
}

class FakeFailingPokemonDataSource: PokemonDataSource() {
    override suspend fun search(): Resource<Pokemon?> {
        return Resource.Error(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }
}