package com.airatlovesmusic.core_network.data

import com.airatlovesmusic.model.Article
import retrofit2.http.GET

/**
 * Created by Airat Khalilov on 23/08/2020.
 */

interface ApiService {
    @GET("multik/master/articles.json")
    suspend fun getArticles(): List<Article>
}