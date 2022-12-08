package com.github.felipecastilhos.pokedexandroid

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.felipecastilhos.pokedexandroid.features.pokemon.PokemonDetailScreen
import com.github.felipecastilhos.pokedexandroid.features.pokemon.PokemonSearchScreen

/**
 * Screens used in [PokemonDestinations]
 */
private object PokemonScreens {
    const val POKEMON_SEARCH = "search"
    const val POKEMON_DETAILS = "details"
}

/**
 * Available routes for Pokemons
 */
object PokemonDestinations {
    const val SEARCH_ROUTE = PokemonScreens.POKEMON_SEARCH
    const val DETAIL_ROUTE = PokemonScreens.POKEMON_DETAILS
}

class PokemonNavigationActions(private val navController: NavController) {
    fun navigateToSearch() {
        navController.navigate(PokemonDestinations .SEARCH_ROUTE) {
            launchSingleTop = true
        }
    }

    fun navigateToDetails() {
        navController.navigate(PokemonDestinations.DETAIL_ROUTE) {
            launchSingleTop = true
        }
    }
}

fun NavGraphBuilder.pokemonGraph(navigationActions: PokemonNavigationActions) {
    composable(PokemonDestinations.SEARCH_ROUTE) {
        PokemonSearchScreen(onNavigateToPokemonDetails = { navigationActions.navigateToDetails() })
    }

    composable(PokemonDestinations.DETAIL_ROUTE) {
        PokemonDetailScreen()
    }
}
