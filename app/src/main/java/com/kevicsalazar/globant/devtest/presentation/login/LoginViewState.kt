package com.kevicsalazar.globant.devtest.presentation.login

sealed class LoginViewState {
    object Success : LoginViewState()
    object Error : LoginViewState()
}