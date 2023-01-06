package com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase

import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.repository.PokemonMockRepository
import javax.inject.Inject

/**
 * Business rules to pokemons informations
 */
class PokemonUseCase @Inject constructor(
    private val pokemonMockRepository: PokemonMockRepository
) {
    fun pokemonList(): Result<List<Pokemon>> {
        return Result.success(pokemonMockRepository.pokemonList())
    }
}
