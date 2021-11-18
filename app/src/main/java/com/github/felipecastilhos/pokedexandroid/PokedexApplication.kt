package com.github.felipecastilhos.pokedexandroid

import android.app.Application
import com.github.felipecastilhos.pokedexandroid.logs.LogHandler
import dagger.hilt.android.HiltAndroidApp

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
