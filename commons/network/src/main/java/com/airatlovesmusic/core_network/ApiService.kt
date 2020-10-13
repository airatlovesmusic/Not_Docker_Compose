package com.airatlovesmusic.core_network

import com.airatlovesmusic.model.Article
import com.airatlovesmusic.model.request.LoginRegisterRequest
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Created by Airat Khalilov on 23/08/2020.
 */

interface ApiClient {
    suspend fun getArticles(): List<Article>
    suspend fun getArticle(id: Int): Article
    suspend fun login(username: String, password: String): String
    suspend fun register(username: String, password: String): String
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

    override suspend fun getArticle(id: Int) =
        client.get<Article>("$BASE_URL/$ARTICLE_ENDPOINT?id=$id") {
            accept(ContentType.Application.Json)
        }

    override suspend fun login(username: String, password: String): String =
            client.post("$BASE_URL/${LOGIN_ENDPOINT}") {
                contentType(ContentType.Application.Json)
                body = LoginRegisterRequest(username, password)
            }

    override suspend fun register(username: String, password: String): String =
            client.post("$BASE_URL/${REGISTER_ENDPOINT}") {
                contentType(ContentType.Application.Json)
                body = LoginRegisterRequest(username, password)
            }

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/airatlovesmusic"
        private const val ARTICLES_ENDPOINT = "articles"
        private const val ARTICLE_ENDPOINT = "article"
        private const val LOGIN_ENDPOINT = "login"
        private const val REGISTER_ENDPOINT = "register"
    }
}