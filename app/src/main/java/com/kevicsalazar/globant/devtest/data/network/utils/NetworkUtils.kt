package com.kevicsalazar.globant.devtest.data.network.utils


import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

const val HEADER_NAME_AUTHORIZATION = "Authorization"

const val HEADER_VALUE_BEARER = "Bearer"


fun createOkHttpClient(
    cache: Cache? = null,
    f: (Request.Builder.() -> Request.Builder)? = null
): OkHttpClient {
    return OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val request = (f?.invoke(requestBuilder) ?: requestBuilder)
            chain.proceed(request.build())
        }
        .addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(3, TimeUnit.MINUTES)
        .connectTimeout(5, TimeUnit.MINUTES)
        .build()
}

fun createRetrofit(httpClient: OkHttpClient, baseUrl: String): Retrofit {
    val contentType = "application/json".toMediaType()
    val json = Json {
        ignoreUnknownKeys = true
    }
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .client(httpClient)
        .build()
}

fun Request.Builder.addAuthorizationHeader(token: String?) = apply {
    token?.also { header(HEADER_NAME_AUTHORIZATION, "$HEADER_VALUE_BEARER $it") }
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): T? {
    val response = call.invoke()
    if (response.isSuccessful) {
        return response.body()
    } else {
        throw HttpException(response)
    }
}
