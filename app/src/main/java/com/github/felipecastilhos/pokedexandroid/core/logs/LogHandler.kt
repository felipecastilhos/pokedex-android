package com.github.felipecastilhos.pokedexandroid.core.logs

import com.github.felipecastilhos.pokedexandroid.BuildConfig
import timber.log.Timber

/**
 * An wrapper to handle logs in the project
 */
object LogHandler {
    fun init(tree: Timber.Tree = Timber.DebugTree()) {
        if (BuildConfig.DEBUG) {
            Timber.plant(tree)
        }
    }

    /** Log a debug exception and a message with optional format args. */
    fun d(message: String, throwable: Throwable? = null) {
        Timber.d(throwable, message)
    }

    /** Log a warning exception and a message with optional format args. */
    fun w(message: String, throwable: Throwable? = null) {
        Timber.w(throwable, message)
    }

    /** Log an info exception. */
    fun i(message: String, throwable: Throwable? = null) {
        Timber.i(throwable, message)
    }

    /** Log an error exception and a message with optional format args. */
    fun e(throwable: Throwable?, message: String? = null) {
        Timber.e(throwable, message)
    }
}

