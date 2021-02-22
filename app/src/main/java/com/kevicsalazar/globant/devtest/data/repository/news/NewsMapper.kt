package com.kevicsalazar.globant.devtest.data.repository.news

import com.kevicsalazar.globant.devtest.data.network.dto.NewsDetailDTO
import com.kevicsalazar.globant.devtest.data.network.dto.NewsItemDTO
import com.kevicsalazar.globant.devtest.domain.entities.NewsDetailItem
import com.kevicsalazar.globant.devtest.domain.entities.NewsItem

class NewsMapper {

    fun map(list: List<NewsItemDTO>): List<NewsItem> {
        return list.map { map(it) }
    }

    private fun map(item: NewsItemDTO): NewsItem {
        return NewsItem(
            item.id,
            item.chapeu,
            item.title,
            item.line,
            item.date,
            item.url,
            item.imageUrl,
            item.source
        )
    }

    fun map(item: NewsDetailDTO.NewsDocumentItem): NewsDetailItem {
        return NewsDetailItem(
            item.id,
            item.url,
            item.source,
            item.product,
            item.editorial,
            item.subeditorial,
            item.title,
            item.credit,
            item.date,
            item.time,
            item.line,
            item.imageUrl,
            item.thumbnail,
            item.creditImage,
            item.legendImage,
            item.origin,
            item.body
        )
    }

}