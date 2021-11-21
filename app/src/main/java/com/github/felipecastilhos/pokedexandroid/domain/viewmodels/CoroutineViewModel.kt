package com.github.felipecastilhos.pokedexandroid.domain.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.felipecastilhos.pokedexandroid.commun.coroutines.DispatcherProvider
import com.github.felipecastilhos.pokedexandroid.commun.coroutines.ScopedContextDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Extends [ViewModel] to run dispatchers inside it's own context.
 * @param dispatcherProvider the implementation of an [DispatcherProvider]
 */
open class CoroutineViewModel(
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val scopedContextProvider =
        ScopedContextDispatcher(
            viewModelScope,
            dispatcherProvider
        )

    /**
     * Launch a coroutine in the I/O context thread
     */
    fun launchInIoScope(
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(io(), start, block)

    /**
     * Launch a coroutine in a main context thread
     */
    fun launchMainScope(
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(main(), start, block)

    /**
     * Get the I/O context from dispatcher provider
     * @return the instance of the I/O context
     */
    private fun io(): CoroutineContext = scopedContextProvider.io

    /**
     * Get the Main context from dispatcher provider
     * @return the instance of the Main context
     */
    private fun main(): CoroutineContext = scopedContextProvider.main

    private fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context, start, block)
}
