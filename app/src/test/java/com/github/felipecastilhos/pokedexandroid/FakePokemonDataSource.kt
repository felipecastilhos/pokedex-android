package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonListRemote

class FakePokemonDataSource(private val pokemon: PokemonRemoteData, private val pokemonList: PokemonListRemote) : PokemonDataSource {
    override suspend fun pokemonData(): Result<PokemonRemoteData> {
        return Result.success(pokemon)
    }

    override suspend fun list(offset: Long, limit: Int): Result<PokemonListRemote> {
        return Result.success(pokemonList)
    }
}

class FakeFailingPokemonDataSource : PokemonDataSource {
    override suspend fun pokemonData(): Result<PokemonRemoteData> {
        return Result.failure(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }

    override suspend fun list(offset: Long, limit: Int): Result<PokemonListRemote> {
        return Result.failure(exception = DataSourceError.Unexpected(R.string.server_unexpected_error))
    }
}