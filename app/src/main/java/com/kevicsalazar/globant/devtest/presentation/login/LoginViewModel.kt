package com.kevicsalazar.globant.devtest.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevicsalazar.globant.devtest.domain.usecases.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    val viewState: LiveData<LoginViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<LoginViewState>()

    fun checkSession() {
        viewModelScope.launch {
            if (loginUseCase.isLogged()) {
                _viewState.postValue(LoginViewState.Success)
            }
        }
    }

    fun login(user: String, password: String) {
        viewModelScope.launch {
            try {
                loginUseCase.login(user, password)
                _viewState.postValue(LoginViewState.Success)
            } catch (e: Exception) {
                e.printStackTrace()
                _viewState.postValue(LoginViewState.Error)
            }
        }
    }

}