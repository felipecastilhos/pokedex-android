package com.github.felipecastilhos.pokedexandroid

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.github.felipecastilhos.pokedexandroid.PokemonDestinationsArgs.POKEMON_DETAIL_ID_ARG
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.list.PokemonSearchScreen
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.list.ui.screens.PokemonDetailScreen

/**
 * Screens used in [PokemonDestinations]
 */
private object PokemonScreens {
    const val POKEMON_SEARCH = "search"
    const val POKEMON_DETAILS = "details"
}

/**
 * Arguments used in [PokemonDestinations] routes
 */
object PokemonDestinationsArgs {
    const val POKEMON_DETAIL_ID_ARG = "pokemonDetailId"
}

/**
 * Available routes for Pokemons
 */
object PokemonDestinations {
    const val SEARCH = PokemonScreens.POKEMON_SEARCH
    const val DETAIL = "${PokemonScreens.POKEMON_DETAILS}/{$POKEMON_DETAIL_ID_ARG}"
}

class PokemonNavigationActions(private val navController: NavController) {
    fun navigateToDetails(pokemonId: Int) {
        navController.navigate("${PokemonScreens.POKEMON_DETAILS}/$pokemonId") {
            launchSingleTop = true
        }
    }
}

fun NavGraphBuilder.pokemonGraph(navigationActions: PokemonNavigationActions) {
    composable(PokemonDestinations.SEARCH) {
        PokemonSearchScreen(onNavigateToPokemonDetails = { id ->
            navigationActions.navigateToDetails(id)
        })
    }

    composable(PokemonDestinations.DETAIL) { _ ->
        val onBackPressedDispatcher =
            LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
        PokemonDetailScreen(onBackClick = { onBackPressedDispatcher?.onBackPressed() })
    }
}
