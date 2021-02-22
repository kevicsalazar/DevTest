package com.kevicsalazar.globant.devtest.domain.repository

import com.kevicsalazar.globant.devtest.domain.entities.NewsDetailItem
import com.kevicsalazar.globant.devtest.domain.entities.NewsItem

interface NewsRepository {

    suspend fun getNewsList(): List<NewsItem>

    suspend fun getNewsDetail(id: String): NewsDetailItem

}