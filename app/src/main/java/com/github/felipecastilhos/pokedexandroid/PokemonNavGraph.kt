package com.github.felipecastilhos.pokedexandroid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun PokemonNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = PokemonDestinations.SEARCH_ROUTE,
    navActions: PokemonNavigationActions = remember(navController) {
        PokemonNavigationActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        pokemonGraph(navActions)
    }
}
