package com.github.felipecastilhos.pokedexandroid.core.di

import com.github.felipecastilhos.pokedexandroid.core.coroutines.AppDispatchersProvider
import com.github.felipecastilhos.pokedexandroid.core.coroutines.DispatcherProvider
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
