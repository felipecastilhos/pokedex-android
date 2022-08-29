package com.github.felipecastilhos.pokedexandroid.features.home.data.datasource

import com.github.felipecastilhos.pokedexandroid.GetPokemonQuery
import com.github.felipecastilhos.pokedexandroid.core.logs.LogHandler
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.FlavorText
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.Pokemon
import com.github.felipecastilhos.pokedexandroid.features.home.domain.models.PokemonTypes

/**
 * Maps [GetPokemonQuery.GetPokemon] to [Pokemon] domain model
 */
fun GetPokemonQuery.GetPokemon.mapToDomainModel(): Pokemon = Pokemon(
    pokedexNumber = this.num,
    species = this.species,
    types = this.types.toTypesDomainModel(),
    height = this.height,
    weight = this.weight,
    flavorText = this.flavorTexts.toFlavorListDomainModel()
)

/**
 * Maps [GetPokemonQuery.FlavorText] list to [FlavorText] domain model list
 */
fun List<GetPokemonQuery.FlavorText>.toFlavorListDomainModel(): List<FlavorText> = map {
    it.toFlavorListDomainModel()
}

/**
 * Maps [GetPokemonQuery.FlavorText] to [FlavorText] domain model
 */
fun GetPokemonQuery.FlavorText.toFlavorListDomainModel(): FlavorText =
    FlavorText(game = game, flavor = flavor)

/**
 * Maps List<String> to list of [PokemonTypes] domain model
 */
fun List<String>.toTypesDomainModel(): List<PokemonTypes?> = map {
    it.mapToTypesDomainModel()
}

/**
 * Maps List<String> to [PokemonTypes] domain model
 */
fun String.mapToTypesDomainModel(): PokemonTypes? =
    try {
        PokemonTypes.valueOf(this)
    } catch (e: IllegalArgumentException) {
        LogHandler.d("Não foi converter para modelo de domínio")
        null
    }
