package com.airatlovesmusic.core_network

import com.airatlovesmusic.model.Article
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/**
 * Created by Airat Khalilov on 23/08/2020.
 */

interface ApiService {
    @GET("multik/master/articles.json")
    suspend fun getArticles(): List<Article>
}

fun getApiService(): ApiService =
    getRetrofit().create(ApiService::class.java)

private fun getOkHttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

private fun getRetrofit(): Retrofit =
    Retrofit.Builder()
        .client(getOkHttpClient())
        .baseUrl("https://raw.githubusercontent.com/airatlovesmusic/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

