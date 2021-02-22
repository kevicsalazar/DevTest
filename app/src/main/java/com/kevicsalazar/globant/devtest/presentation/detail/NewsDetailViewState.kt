package com.kevicsalazar.globant.devtest.presentation.detail

import com.kevicsalazar.globant.devtest.domain.entities.NewsDetailItem

sealed class NewsDetailViewState {
    class Success(val item: NewsDetailItem) : NewsDetailViewState()
    object Error : NewsDetailViewState()
}