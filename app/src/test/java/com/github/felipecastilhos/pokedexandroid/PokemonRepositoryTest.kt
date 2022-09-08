package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.*
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
        species = Specie("Squirtle", ""),
        types = listOf(PokemonTypes(1, PokemonType(typeName = TypeName.Water, url = ""))),
        height = 0.5,
        weight = 9.0
    )

    private lateinit var fakePokemonDataSource: FakePokemonDataSource
    private lateinit var pokemonRepository: DefaultPokemonRemoteDataRepository
    
    @Before
    fun createRepository() {
        mockSuccessRepository()
    }

    private fun mockSuccessRepository() {
        fakePokemonDataSource = FakePokemonDataSource(pokemonSquirtle)
        pokemonRepository = DefaultPokemonRemoteDataRepository(fakePokemonDataSource)
    }

    private fun mockFailingRepository() {
        pokemonRepository = DefaultPokemonRemoteDataRepository(FakeFailingPokemonDataSource())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun searchPokemon_GetSquirtle() = runTest {
        val result = pokemonRepository.search()
        assert(result.getOrNull()?.pokedexNumber == 7)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun searchPokemonInFailingRepository_GetResultIsFailure() = runTest {
        mockFailingRepository()
        val result = pokemonRepository.search()
        assert(result.isFailure)
    }
}