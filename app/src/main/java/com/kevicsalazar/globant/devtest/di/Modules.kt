package com.kevicsalazar.globant.devtest.di

import android.app.Application
import com.kevicsalazar.globant.devtest.data.network.di.networkModule
import com.kevicsalazar.globant.devtest.data.preferences.di.preferencesModule
import com.kevicsalazar.globant.devtest.data.repository.di.repositoryModule
import com.kevicsalazar.globant.devtest.domain.di.domainModule
import com.kevicsalazar.globant.devtest.presentation.di.featureModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

internal fun injectModules(app: Application) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(getModules())
    }
}

private fun getModules() = listOf(
    preferencesModule,
    repositoryModule,
    networkModule,
    domainModule,
    featureModule
)