package com.airatlovesmusic.core_network

import com.airatlovesmusic.model.Article
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Created by Airat Khalilov on 23/08/2020.
 */

interface ApiClient {
    suspend fun getArticles(): List<Article>
}

class ApiClientImpl: ApiClient {

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    override suspend fun getArticles() =
        client.get<List<Article>>("$BASE_URL/$ARTICLES_ENDPOINT") {
            accept(ContentType.Application.Json)
        }

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/airatlovesmusic"
        const val ARTICLES_ENDPOINT = "multik/master/articles.json"
    }
}