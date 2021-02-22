package com.kevicsalazar.globant.devtest.domain.di

import com.kevicsalazar.globant.devtest.domain.usecases.GetNewsDetailUseCase
import com.kevicsalazar.globant.devtest.domain.usecases.GetNewsListUseCase
import com.kevicsalazar.globant.devtest.domain.usecases.LoginUseCase
import com.kevicsalazar.globant.devtest.domain.usecases.LogoutUseCase
import org.koin.dsl.module

internal val domainModule = module {
    factory { GetNewsDetailUseCase(get()) }
    factory { GetNewsListUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { LogoutUseCase(get()) }
}