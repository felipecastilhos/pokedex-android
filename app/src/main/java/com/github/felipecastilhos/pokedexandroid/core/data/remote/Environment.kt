package com.github.felipecastilhos.pokedexandroid.core.data.remote

/**
 * Configurations of enviroments of the data sources
 */
sealed class Environment(val pokeApiUrl: String) {
    object Production :
        Environment("https://pokeapi.co/api/v2/")
}
