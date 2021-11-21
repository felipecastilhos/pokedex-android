package com.github.felipecastilhos.pokedexandroid.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Provides the default App dispatchers
 */
object AppDispatchersProvider :
    DispatcherProvider {
    /**
     * Provides the main dispatcher
     */
    override val main: CoroutineDispatcher = Dispatchers.Main

    /**
     * Provides the I/O dispatcher
     */
    override val io: CoroutineDispatcher = Dispatchers.IO
}
