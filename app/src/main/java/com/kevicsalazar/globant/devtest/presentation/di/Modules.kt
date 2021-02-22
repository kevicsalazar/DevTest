package com.kevicsalazar.globant.devtest.presentation.di

import com.kevicsalazar.globant.devtest.presentation.detail.NewsDetailViewModel
import com.kevicsalazar.globant.devtest.presentation.list.NewsListViewModel
import com.kevicsalazar.globant.devtest.presentation.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val featureModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { NewsListViewModel(get(), get()) }
    viewModel { NewsDetailViewModel(get()) }
}