package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.source.models

import com.squareup.moshi.Json

data class Pokemon(
    @field:Json(name = "id") val pokedexNumber: Int,
    @field:Json(name = "species") val species: Specie,
    @field:Json(name = "types") val types: List<PokemonTypes?>,
    @field:Json(name = "height") val height: Double,
    @field:Json(name = "weight") val weight: Double,
)

data class Specie(val name: String, val url: String)

data class PokemonTypes(val slot: Int, val type: PokemonType)
data class PokemonType(@field:Json(name = "name") val typeName: TypeName, val url: String)

enum class TypeName {
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
