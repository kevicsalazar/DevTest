package com.kevicsalazar.globant.devtest.data.network.di


import com.kevicsalazar.globant.devtest.data.network.AppApi
import com.kevicsalazar.globant.devtest.data.network.utils.addAuthorizationHeader
import com.kevicsalazar.globant.devtest.data.network.utils.createOkHttpClient
import com.kevicsalazar.globant.devtest.data.network.utils.createRetrofit
import com.kevicsalazar.globant.devtest.data.preferences.AppPreferences
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

const val HOST = "https://teste-dev-mobile-api.herokuapp.com/"

internal val networkModule = module {
    single { createAppHttpClient(get()) }
    single { retrofitApp(get()) }
    single { provideAppApi(get()) }
}

/**
 * App Api
 * */

private fun createAppHttpClient(preferences: AppPreferences): OkHttpClient {
    return createOkHttpClient {
        addAuthorizationHeader(preferences.token)
    }
}

private fun retrofitApp(okHttpClient: OkHttpClient): Retrofit {
    return createRetrofit(okHttpClient, HOST)
}

private fun provideAppApi(retrofit: Retrofit): AppApi {
    return retrofit.create(AppApi::class.java)
}