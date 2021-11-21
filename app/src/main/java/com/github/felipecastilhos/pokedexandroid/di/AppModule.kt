package com.github.felipecastilhos.pokedexandroid.di

import com.github.felipecastilhos.pokedexandroid.commun.coroutines.AppDispatchersProvider
import com.github.felipecastilhos.pokedexandroid.commun.coroutines.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * [AppModule] provides communs components for the architecture over the application
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providesDispatcherProvider(): DispatcherProvider {
        return AppDispatchersProvider
    }
}
