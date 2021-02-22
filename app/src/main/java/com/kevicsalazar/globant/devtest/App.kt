package com.kevicsalazar.globant.devtest

import android.app.Application
import com.kevicsalazar.globant.devtest.di.injectModules

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        injectModules()
    }

    private fun injectModules() {
        injectModules(this)
    }

}