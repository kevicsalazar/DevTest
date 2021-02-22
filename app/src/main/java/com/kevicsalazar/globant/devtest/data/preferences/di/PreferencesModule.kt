package com.kevicsalazar.globant.devtest.data.preferences.di

import android.content.Context
import com.kevicsalazar.globant.devtest.data.preferences.AppPreferences
import org.koin.dsl.module

val preferencesModule = module {
    single { AppPreferences(get<Context>().appPreferences) }
}

private val Context.appPreferences
    get() = getSharedPreferences(AppPreferences.PREFERENCES_NAME, Context.MODE_PRIVATE)
