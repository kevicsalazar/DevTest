package com.kevicsalazar.globant.devtest.domain.usecases

import com.kevicsalazar.globant.devtest.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun login(user: String, password: String) {
        authRepository.login(user, password)
    }

    suspend fun isLogged(): Boolean {
        return authRepository.isLogged()
    }

}