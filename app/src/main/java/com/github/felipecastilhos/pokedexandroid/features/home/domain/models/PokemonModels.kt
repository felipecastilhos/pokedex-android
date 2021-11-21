package com.github.felipecastilhos.pokedexandroid.features.home.domain.models

data class Pokemon(
    val pokedexNumber: Int,
    val species: String,
    val types: List<PokemonTypes?>,
    val height: Double,
    val weight: Double,
    val flavorText: List<FlavorText>
)

data class FlavorText(val game: String, val flavor: String)

enum class PokemonTypes {
    Normal,
    Fighting,
    Flying,
    Poison,
    Ground,
    Rock,
    Bug,
    Ghost,
    Steel,
    Fire,
    Water,
    Glass,
    Eletric,
    Psychic,
    Ice,
    Dragon,
    Dark,
    Fairy,
    Unknown
}
