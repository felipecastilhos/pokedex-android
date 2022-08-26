package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.core.datasource.Resource
import com.github.felipecastilhos.pokedexandroid.features.home.SearchPokemonResult
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.FlavorText
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.PokemonTypes
import com.github.felipecastilhos.pokedexandroid.features.home.domain.repository.DefaultPokemonRemoteDataRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonRepositoryTest {
    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val pokemonSquirtle = Pokemon(
        pokedexNumber = 7,
        species = "Tiny turtle",
        types = listOf(PokemonTypes.Water),
        height = 0.5,
        weight = 9.0,
        listOf(
            FlavorText(
                game = "Black",
                flavor = "It shelters itself in its shell, then strikes back with spouts of water at every opportunity."
            )
        )
    )

    private lateinit var fakePokemonDataSource: FakePokemonDataSource
    private lateinit var pokemonRepository: DefaultPokemonRemoteDataRepository

    @Before
    fun createRepository() {
        fakePokemonDataSource = FakePokemonDataSource(pokemonSquirtle)
        pokemonRepository = DefaultPokemonRemoteDataRepository(fakePokemonDataSource)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun searchPokemon_GetSquirtle() = runTest {
        val result = pokemonRepository.search()
        result as Resource.Success<Pokemon?>
        assert(result.data?.pokedexNumber == 7)
    }
}