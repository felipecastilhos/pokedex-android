package com.github.felipecastilhos.pokedexandroid

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This module creates all components used in the Home feature
 */
@Module
@InstallIn(SingletonComponent::class)
class HomeModule {
    /**
     * Provides the [PokemonUseCase] component
     * @param apolloClient to performs the query into pokemon-graphql api
     */
    @Provides
    fun providesPokemonUseCase(apolloClient: ApolloClient?): PokemonUseCase {
        return PokemonUseCase(apolloClient)
    }
}
