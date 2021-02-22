package com.kevicsalazar.globant.devtest.data.repository.auth

import com.kevicsalazar.globant.devtest.data.network.AppApi
import com.kevicsalazar.globant.devtest.data.network.utils.safeApiCall
import com.kevicsalazar.globant.devtest.data.preferences.AppPreferences
import com.kevicsalazar.globant.devtest.domain.repository.AuthRepository

class AuthDataRepository(
    private val api: AppApi,
    private val appPreferences: AppPreferences
) : AuthRepository {

    override suspend fun login(user: String, password: String) {
        val response = safeApiCall { api.login(user, password) }
        appPreferences.token = requireNotNull(response).token
    }

    override suspend fun logout() {
        appPreferences.clear()
    }

    override suspend fun isLogged(): Boolean {
        return appPreferences.token != null
    }
}