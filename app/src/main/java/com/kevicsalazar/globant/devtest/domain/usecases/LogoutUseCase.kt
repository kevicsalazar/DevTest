package com.kevicsalazar.globant.devtest.domain.usecases

import com.kevicsalazar.globant.devtest.domain.repository.AuthRepository

class LogoutUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun logout() {
        authRepository.logout()
    }

}