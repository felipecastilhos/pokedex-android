package com.github.felipecastilhos.pokedexandroid.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Class to abstract the direct usage of dispatcher
 * This helps to use inject coroutines in tests
 */
interface DispatcherProvider {
    /**
     +-----------------------------------+
     | Main thread on Android, interact  |
     | with the UI and perform light     |
     | work                              |
     +-----------------------------------+
     | - Calling suspend functions       |
     | - Call UI functions               |
     | - Updating LiveData               |
     +-----------------------------------+
     */
    val main: CoroutineDispatcher

    /**
     +-----------------------------------+
     | Optimized for disk and network IO |
     | off the main thread               |
     +-----------------------------------+
     | - Database                        |
     | - Reading/writing files           |
     | - Networking                      |
     +-----------------------------------+
     */
    val io: CoroutineDispatcher
}
