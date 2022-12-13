package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonRemoteDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.*
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRestService
import com.github.felipecastilhos.pokedexandroid.features.pokemon.di.PokemonListModule
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.DefaultPokemonRemoteDataRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase.PokemonUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import retrofit2.Retrofit
import javax.inject.Singleton


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
        val pokemonSquirtle = Pokemon(
            pokedexNumber = 7,
            species = Specie("Squirtle", ""),
            types = listOf(PokemonTypes(1, PokemonType(typeName = TypeName.Water, url = ""))),
            height = 0.5,
            weight = 9.0
        )

        val pokemonEntries =
            listOf(PokemonListEntry("Bulbassauro", "http://pokeapi/bulba"))
        val pokemonList = PokemonList(0L, "21", "20", pokemonEntries)

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


class FakePokemonDataSource(private val pokemon: Pokemon, private val pokemonList: PokemonList) :
    PokemonDataSource {
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