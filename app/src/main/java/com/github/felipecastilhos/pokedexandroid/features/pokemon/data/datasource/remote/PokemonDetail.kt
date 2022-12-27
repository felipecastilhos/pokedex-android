package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote

import com.squareup.moshi.Json

/**
 * Represents remote data abaut a Pokemon
 */
data class PokemonRemoteData(
    @field:Json(name = "id") val pokedexNumber: Int,
    @field:Json(name = "species") val species: SpecieRemoteData,
    @field:Json(name = "types") val types: List<PokemonTypesRemoteData?>,
    @field:Json(name = "height") val height: Double,
    @field:Json(name = "weight") val weight: Double,
)

/**
 * Reepresents remote data about a Pokemonb
 */
data class SpecieRemoteData(val name: String, val url: String)

data class PokemonTypesRemoteData(val slot: Int, val type: PokemonTypeRemoteData)
data class PokemonTypeRemoteData(@field:Json(name = "name") val typeName: TypeNameRemoteData, val url: String)

enum class TypeNameRemoteData {
    @field:Json(name = "normal")
    Normal,

    @field:Json(name = "fighting")
    Fighting,

    @field:Json(name = "flying")
    Flying,

    @field:Json(name = "poison")
    Poison,

    @field:Json(name = "ground")
    Ground,

    @field:Json(name = "rock")
    Rock,

    @field:Json(name = "bug")
    Bug,

    @field:Json(name = "ghost")
    Ghost,

    @field:Json(name = "steel")
    Steel,

    @field:Json(name = "fire")
    Fire,

    @field:Json(name = "water")
    Water,

    @field:Json(name = "glass")
    Glass,

    @field:Json(name = "electric")
    Electric,

    @field:Json(name = "psychic")
    Psychic,

    @field:Json(name = "ice")
    Ice,

    @field:Json(name = "dragon")
    Dragon,

    @field:Json(name = "dark")
    Dark,

    @field:Json(name = "fairy")
    Fairy,

    @field:Json(name = "unknown")
    Unknown
}
