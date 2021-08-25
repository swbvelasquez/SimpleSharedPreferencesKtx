package com.tutoriales.simplesharedpreferencesktx

import android.app.Application

// Esto permite inicializar informacion o clases cuando inicia la aplicacion, antes de que se genere la activity
class SharedApplication : Application() {

    //Permite que toda la aplicacion pueda utilizar esta clase, variable, etc
    companion object{
        lateinit var generalPreferences: Preferences
    }

    override fun onCreate() {
        super.onCreate()
        generalPreferences = Preferences(applicationContext)
    }
}