package com.github.felipecastilhos.pokedexandroid

import com.github.felipecastilhos.pokedexandroid.coroutines.AppDispatchersProvider
import com.github.felipecastilhos.pokedexandroid.coroutines.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providesDispatcherProvider(): DispatcherProvider {
        return AppDispatchersProvider
    }
}
