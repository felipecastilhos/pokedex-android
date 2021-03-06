package com.github.felipecastilhos.pokedexandroid.core.datasource.remote

/**
 * Configurations of enviroments of the data sources
 */
sealed class Enviroment(val graphQlUrl: String) {
    object Production : Enviroment("https://graphqlpokemon.favware.tech/")
}
