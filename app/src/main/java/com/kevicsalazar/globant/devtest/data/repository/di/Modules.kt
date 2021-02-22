package com.kevicsalazar.globant.devtest.data.repository.di

import com.kevicsalazar.globant.devtest.data.repository.auth.AuthDataRepository
import com.kevicsalazar.globant.devtest.data.repository.news.NewsDataRepository
import com.kevicsalazar.globant.devtest.data.repository.news.NewsMapper
import com.kevicsalazar.globant.devtest.domain.repository.AuthRepository
import com.kevicsalazar.globant.devtest.domain.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { NewsMapper() }
    factory<NewsRepository> { NewsDataRepository(get(), get()) }
    factory<AuthRepository> { AuthDataRepository(get(), get()) }
}