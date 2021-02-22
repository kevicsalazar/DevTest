package com.kevicsalazar.globant.devtest.domain.usecases

import com.kevicsalazar.globant.devtest.domain.entities.NewsDetailItem
import com.kevicsalazar.globant.devtest.domain.repository.NewsRepository

class GetNewsDetailUseCase(
    private val newsRepository: NewsRepository
) {

    suspend fun getNewsDetail(id: String): NewsDetailItem {
        return newsRepository.getNewsDetail(id)
    }

}