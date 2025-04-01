package app.medicines

import android.app.Application
import app.medicines.data.AppContainer
import app.medicines.data.AppDataContainer

class MedicinesApplication : Application() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}