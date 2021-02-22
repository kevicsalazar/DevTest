package com.kevicsalazar.globant.devtest.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevicsalazar.globant.devtest.domain.usecases.GetNewsDetailUseCase
import kotlinx.coroutines.launch

class NewsDetailViewModel(
    private val getNewsDetailUseCase: GetNewsDetailUseCase
) : ViewModel() {

    val viewState: LiveData<NewsDetailViewState>
        get() = _viewState

    private val _viewState = MutableLiveData<NewsDetailViewState>()

    fun getNewsDetail(id: String) {
        viewModelScope.launch {
            try {
                val item = getNewsDetailUseCase.getNewsDetail(id)
                _viewState.postValue(NewsDetailViewState.Success(item))
            } catch (e: Exception) {
                e.printStackTrace()
                _viewState.postValue(NewsDetailViewState.Error)
            }
        }
    }

}