package com.kevicsalazar.globant.devtest.domain.usecases

import com.kevicsalazar.globant.devtest.domain.entities.NewsItem
import com.kevicsalazar.globant.devtest.domain.repository.NewsRepository

class GetNewsListUseCase(
    private val newsRepository: NewsRepository
) {

    suspend fun getNewsList(): List<NewsItem> {
        return newsRepository.getNewsList()
    }

}