package com.github.felipecastilhos.pokedexandroid.features.home

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
     * Provides the [PokemonRepository] component
     * @param apolloClient to performs the query into pokemon-graphql api
     */
    @Provides
    fun providesPokemonUseCase(apolloClient: ApolloClient?): PokemonRepository {
        return PokemonRepository(apolloClient)
    }
}
