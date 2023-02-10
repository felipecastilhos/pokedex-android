package com.github.felipecastilhos.pokedexandroid

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.github.felipecastilhos.pokedexandroid.PokemonDestinationsArgs.POKEMON_DETAIL_ID_ARGS
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.screens.PokemonDetailScreen
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.screens.PokemonSearchScreen
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.viewmodel.PokemonDetailViewModel
import com.github.felipecastilhos.pokedexandroid.features.pokemon.presentation.viewmodel.PokemonListViewModel
import kotlinx.coroutines.runBlocking

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
    const val POKEMON_DETAIL_ID_ARGS = "pokemonDetailId"
}

/**
 * Available routes for Pokemons
 */
object PokemonDestinations {
    const val SEARCH_ROUTE = PokemonScreens.POKEMON_SEARCH
    const val DETAIL_ROUTE = PokemonScreens.POKEMON_DETAILS
}

class PokemonNavigationActions(private val navController: NavController) {
    fun navigateToDetails(pokemonId: Int) {
        navController.navigate("${PokemonDestinations.DETAIL_ROUTE}/$pokemonId") {
            launchSingleTop = true
        }
    }
}

fun NavGraphBuilder.pokemonGraph(navigationActions: PokemonNavigationActions) {
    composable(PokemonDestinations.SEARCH_ROUTE) {
        val viewModel: PokemonListViewModel = hiltViewModel()
        val uiState = viewModel.stateFlow.collectAsState().value
        PokemonSearchScreen(
            onNavigateToPokemonDetails = { id -> navigationActions.navigateToDetails(id) },
            uiState = uiState
        )
    }

    composable("${PokemonDestinations.DETAIL_ROUTE}/{$POKEMON_DETAIL_ID_ARGS}",
        arguments = listOf(
            navArgument(POKEMON_DETAIL_ID_ARGS) { type = NavType.IntType; defaultValue = 0 }
        )
    ) { entry ->
        val viewModel: PokemonDetailViewModel = hiltViewModel()
        val uiState = viewModel.stateFlow.collectAsState().value

        runBlocking {
            viewModel.searchPokemon(entry.arguments?.getInt(POKEMON_DETAIL_ID_ARGS) ?: 0)
        }
        val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher

        if(uiState.pokemonDetail != null)  PokemonDetailScreen(pokemonDetails = uiState.pokemonDetail, onBackClick = { dispatcher.onBackPressed() })
    }
}
