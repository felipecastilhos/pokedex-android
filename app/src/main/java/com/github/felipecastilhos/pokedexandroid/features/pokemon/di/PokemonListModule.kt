package com.github.felipecastilhos.pokedexandroid.features.pokemon.di

import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.PokemonRemoteDataSource
import com.github.felipecastilhos.pokedexandroid.features.pokemon.data.datasource.remote.PokemonRestService
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.DefaultPokemonRemoteDataRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.repository.PokemonRepository
import com.github.felipecastilhos.pokedexandroid.features.pokemon.domain.usecase.PokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * This module creates all components used in the Home feature
 */
@Module
@InstallIn(SingletonComponent::class)
class PokemonListModule {
    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit): PokemonRestService =
        retrofit.create(PokemonRestService::class.java)

    /**
     * Provides a remote data source for home data
     */
    @Provides
    fun providesHomeRemoteDataSource(
        pokemonRestService: PokemonRestService,
        dispatcherProvider: DispatcherProvider
    ): PokemonDataSource {
        return PokemonRemoteDataSource(pokemonRestService, dispatcherProvider)
    }

    /**
     * Provides the [PokemonRepository] logic how to fetch pokemon data
     * @param pokemonRemoteDataSource logic how home pokedex repository fetch its pokemon's data
     */
    @Provides
    fun providesPokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository {
        return DefaultPokemonRemoteDataRepository(pokemonRemoteDataSource)
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