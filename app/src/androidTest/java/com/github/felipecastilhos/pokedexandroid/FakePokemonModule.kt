package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.data.remote.DataSourceError
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonList
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonListEntry
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonType
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.PokemonTypes
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.Specie
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.TypeName
import com.github.felipecastilhos.pokedexandroid.features.pokemon.di.PokemonListModule
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonMockRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonRepository
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
    fun providesPokemonRepository(): PokemonMockRepository {
        return PokemonMockRepository()
    }

    /**
     * Provides the [PokemonUseCase] for view model business logic
     * @param pokemonRemoteDataRepository contains all pokemon related data
     */
    @Provides
    fun providesPokemonUseCase(pokemonRemoteDataRepository: PokemonMockRepository): PokemonUseCase {
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
