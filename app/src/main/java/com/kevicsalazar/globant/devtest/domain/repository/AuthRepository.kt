package com.kevicsalazar.globant.devtest.domain.repository

interface AuthRepository {

    suspend fun login(user: String, password: String)

    suspend fun logout()

    suspend fun isLogged(): Boolean

}