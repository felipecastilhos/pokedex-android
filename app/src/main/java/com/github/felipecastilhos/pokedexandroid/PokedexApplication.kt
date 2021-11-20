package com.github.felipecastilhos.pokedexandroid

import android.app.Application
import com.github.felipecastilhos.pokedexandroid.commun.logs.LogHandler
import dagger.hilt.android.HiltAndroidApp

/**
 * Create an application for the pokedex app to extends adding needed behaviours
 */
@HiltAndroidApp
class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        dependenciesInitialize()
    }

    /**
     * Inits all projects dependencies.
     */
    private fun dependenciesInitialize() {
        LogHandler.init()
    }
}
