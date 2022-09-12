package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models

/**
 * Pokemon list model from the remote data source
 */
data class PokemonList(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListEntry>
)

/**
 * Pokemon entry for listing
 */
data class PokemonListEntry(val name: String, val url: String)