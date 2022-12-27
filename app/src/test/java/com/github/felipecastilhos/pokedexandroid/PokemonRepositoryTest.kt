package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models.*
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonTypeRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonTypesRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.SpecieRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.TypeNameRemoteData
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.repository.DefaultPokemonRemoteDataRepository
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

    private val pokemonSquirtle = PokemonRemoteData(
        pokedexNumber = 7,
        species = SpecieRemoteData("Squirtle", ""),
        types = listOf(PokemonTypesRemoteData(1, PokemonTypeRemoteData(typeName = TypeNameRemoteData.Water, url = ""))),
        height = 0.5,
        weight = 9.0
    )

    private val pokemonEntries = listOf<PokemonListEntryRemote>(PokemonListEntryRemote("Bulbassauro", "http://pokeapi/bulba"))
    private val pokemonList = PokemonListRemote(0L, "21", "20", pokemonEntries)

    private lateinit var fakePokemonDataSource: FakePokemonDataSource
    private lateinit var pokemonRepository: DefaultPokemonRemoteDataRepository
    
    @Before
    fun createRepository() {
        mockSuccessRepository()
    }

    private fun mockSuccessRepository() {
        fakePokemonDataSource = FakePokemonDataSource(pokemonSquirtle, pokemonList)
        pokemonRepository = DefaultPokemonRemoteDataRepository(fakePokemonDataSource)
    }

    private fun mockFailingRepository() {
        pokemonRepository = DefaultPokemonRemoteDataRepository(FakeFailingPokemonDataSource())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun searchPokemon_GetSquirtle() = runTest {
        val result = pokemonRepository.pokemonData()
        assert(result.getOrNull()?.pokedexNumber == 7)
    }

    @Test
    fun search_GetBulbassauroInPokemonList() = runTest {
        val result = pokemonRepository.list(0, 10)
        assert(result.getOrNull()?.results?.first()?.name == "Bulbassauro")
    }

    @ExperimentalCoroutinesApi
    @Test
    fun searchPokemonInFailingRepository_GetResultIsFailure() = runTest {
        mockFailingRepository()
        val result = pokemonRepository.pokemonData()
        assert(result.isFailure)
    }
}