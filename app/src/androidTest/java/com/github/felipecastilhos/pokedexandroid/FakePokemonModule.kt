package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonRemoteDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonListRemote
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonListEntryRemote
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonTypeRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonTypesRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.SpecieRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.TypeNameRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.di.PokemonListModule
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.repository.DefaultPokemonRemoteDataRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.repository.PokemonRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase.PokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [PokemonListModule::class]
)
class FakePokemonModule {
    /**
     * Provides a remote data source for home data
     */
    @Provides
    fun providesHomeRemoteDataSource(): PokemonDataSource {
        val pokemonSquirtle = PokemonRemoteData(
            pokedexNumber = 7,
            species = SpecieRemoteData("Squirtle", ""),
            types = listOf(PokemonTypesRemoteData(1, PokemonTypeRemoteData(typeName = TypeNameRemoteData.Water, url = ""))),
            height = 0.5,
            weight = 9.0
        )

        val pokemonEntries =
            listOf(PokemonListEntryRemote("Bulbassauro", "http://pokeapi/bulba"))
        val pokemonList = PokemonListRemote(0L, "21", "20", pokemonEntries)

        return FakePokemonDataSource(pokemon = pokemonSquirtle, pokemonList = pokemonList)
    }

    /**
     * Provides the [PokemonRepository] logic how to fetch pokemon data
     * @param pokemonRemoteDataSource logic how home pokedex repository fetch its pokemon's data
     */
    @Provides
    fun providesPokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository {
        return DefaultPokemonRemoteDataRepository(pokemonRemoteDataSource)
    }

    /**
     * Provides the [PokemonUseCase] for view model business logic
     * @param pokemonRemoteDataRepository contains all pokemon related data
     */
    @Provides
    fun providesPokemonUseCase(pokemonRemoteDataRepository: DefaultPokemonRemoteDataRepository): PokemonUseCase {
        return PokemonUseCase(pokemonRemoteDataRepository)
    }
}

class FakePokemonDataSource(private val pokemon: PokemonRemoteData, private val pokemonList: PokemonListRemote) :
    PokemonDataSource {
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
