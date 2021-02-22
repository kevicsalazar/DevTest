package com.kevicsalazar.globant.devtest.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevicsalazar.globant.devtest.domain.usecases.GetNewsListUseCase
import com.kevicsalazar.globant.devtest.domain.usecases.LogoutUseCase
import kotlinx.coroutines.launch

class NewsListViewModel(
    private val getNewsListUseCase: GetNewsListUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    val viewState: LiveData<NewsListViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<NewsListViewState>()

    fun getNewsList() {
        viewModelScope.launch {
            try {
                val items = getNewsListUseCase.getNewsList()
                _viewState.postValue(NewsListViewState.Success(items))
            } catch (e: Exception) {
                e.printStackTrace()
                _viewState.postValue(NewsListViewState.Error)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                logoutUseCase.logout()
                _viewState.postValue(NewsListViewState.GoToLogin)
            } catch (e: Exception) {
                e.printStackTrace()
                _viewState.postValue(NewsListViewState.Error)
            }
        }
    }

}