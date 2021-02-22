package com.kevicsalazar.globant.devtest.data.preferences

import android.content.SharedPreferences

class AppPreferences(private val preferences: SharedPreferences) {

    companion object {

        const val PREFERENCES_NAME = "AppPreferences"

        const val KEY_TOKEN = "token"

    }

    var token: String?
        get() = preferences.getString(KEY_TOKEN, null)
        set(value) = preferences.edit().putString(KEY_TOKEN, value).apply()

    fun clear() {
        preferences.edit().clear().apply()
    }

}