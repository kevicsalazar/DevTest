package com.kevicsalazar.globant.devtest.presentation.list

import com.kevicsalazar.globant.devtest.domain.entities.NewsItem

sealed class NewsListViewState {
    class Success(val items: List<NewsItem>) : NewsListViewState()
    object Error : NewsListViewState()
    object GoToLogin : NewsListViewState()
}