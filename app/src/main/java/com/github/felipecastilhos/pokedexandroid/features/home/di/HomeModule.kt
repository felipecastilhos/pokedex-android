package com.github.felipecastilhos.pokedexandroid.features.home.di

import com.apollographql.apollo.ApolloClient
import com.github.felipecastilhos.pokedexandroid.features.home.datasource.HomeRemoteDataSource
import com.github.felipecastilhos.pokedexandroid.features.home.datasource.HomeRemoteGraphQlDataSourceImpl
import com.github.felipecastilhos.pokedexandroid.features.home.domain.repository.PokemonRemoteDataRepositoryImpl
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
    fun providesHomeRemoteDataSource(
        apolloClient: ApolloClient
    ): HomeRemoteDataSource {
        return HomeRemoteGraphQlDataSourceImpl(apolloClient)
    }

    /**
     * Provides the [PokemonRepository] logic how to fetch pokemon data
     * @param homeRemoteGraphQlDataSourceImpl logic how home pokedex repository fetch its pokemon's data
     */
    @Provides
    fun providesPokemonRepository(homeRemoteGraphQlDataSourceImpl: HomeRemoteGraphQlDataSourceImpl): PokemonRepository {
        return PokemonRemoteDataRepositoryImpl(homeRemoteGraphQlDataSourceImpl)
    }

    /**
     * Provides the [PokemonUseCase] for view model business logic
     * @param pokemonRemoteDataRepository contains all pokemon related data
     */
    @Provides
    fun providesPokemonUseCase(pokemonRemoteDataRepository: PokemonRemoteDataRepositoryImpl): PokemonUseCase {
        return PokemonUseCase(pokemonRemoteDataRepository)
    }
}
