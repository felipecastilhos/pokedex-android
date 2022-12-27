package com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.models

/**
 * Pokemon list model from the remote data source
 */
data class PokemonListRemote(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListEntryRemote>
)

/**
 * Pokemon entry for listing
 */
data class PokemonListEntryRemote(val name: String, val url: String)