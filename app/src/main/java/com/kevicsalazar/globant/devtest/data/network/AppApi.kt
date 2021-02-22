package com.kevicsalazar.globant.devtest.data.network

import com.kevicsalazar.globant.devtest.data.network.dto.LoginDTO
import com.kevicsalazar.globant.devtest.data.network.dto.NewsDetailDTO
import com.kevicsalazar.globant.devtest.data.network.dto.NewsItemDTO
import retrofit2.Response
import retrofit2.http.*


interface AppApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("user") user: String,
        @Field("pass") pass: String
    ): Response<LoginDTO>

    @Headers("Content-Type: application/json")
    @GET("news")
    suspend fun getNewsList(): Response<List<NewsItemDTO>>

    @Headers("Content-Type: application/json")
    @GET("news/{id}")
    suspend fun getNewsDetail(@Path("id") id: String): Response<List<NewsDetailDTO>>

}
