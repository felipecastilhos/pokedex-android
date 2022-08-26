package com.github.felipecastilhos.pokedexandroid.features.home.di

import com.apollographql.apollo.ApolloClient
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.home.data.datasource.PokemonGraphQlDataSource
import com.github.felipecastilhos.pokedexandroid.features.home.domain.repository.DefaultPokemonRemoteDataRepository
import com.github.felipecastilhos.pokedexandroid.features.home.domain.repository.PokemonRepository
import com.github.felipecastilhos.pokedexandroid.features.home.domain.usecase.PokemonUseCase
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
     * Provides a remote data source for home data
     */
    @Provides
    fun providesHomeRemoteDataSourceExecutor(
        apolloClient: ApolloClient
    ): PokemonDataSource {
        return PokemonGraphQlDataSource(apolloClient)
    }

    /**
     * Provides the [PokemonRepository] logic how to fetch pokemon data
     * @param homeRemoteGraphQlDataSourceExecutor logic how home pokedex repository fetch its pokemon's data
     */
    @Provides
    fun providesPokemonRepository(
        homeRemoteGraphQlDataSourceExecutor: PokemonGraphQlDataSource
    ): PokemonRepository {
        return DefaultPokemonRemoteDataRepository(homeRemoteGraphQlDataSourceExecutor)
    }

    /**
     * Provides the [PokemonUseCase] for view model business logic
     * @param pokemonRemoteDataRepository contains all pokemon related data
     */
    @Provides
    fun providesPokemonUseCase(pokemonRemoteDataRepository: DefaultPokemonRemoteDataRepository): PokemonUseCase {
        return PokemonUseCase(pokemonRemoteDataRepository)
    }
}
