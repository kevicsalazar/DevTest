package com.kevicsalazar.globant.devtest.data.repository.news

import com.kevicsalazar.globant.devtest.data.network.AppApi
import com.kevicsalazar.globant.devtest.data.network.utils.safeApiCall
import com.kevicsalazar.globant.devtest.domain.entities.NewsDetailItem
import com.kevicsalazar.globant.devtest.domain.entities.NewsItem
import com.kevicsalazar.globant.devtest.domain.repository.NewsRepository

class NewsDataRepository(
    private val api: AppApi,
    private val newsMapper: NewsMapper
) : NewsRepository {

    override suspend fun getNewsList(): List<NewsItem> {
        val response = safeApiCall { api.getNewsList() }
        return newsMapper.map(requireNotNull(response))
    }

    override suspend fun getNewsDetail(id: String): NewsDetailItem {
        val response = safeApiCall { api.getNewsDetail(id) }
        return newsMapper.map(requireNotNull(response?.firstOrNull()?.document))
    }
}