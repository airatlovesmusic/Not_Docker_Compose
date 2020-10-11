package com.airatlovesmusic.compose.screens.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.airatlovesmusic.core_network.ApiService
import com.airatlovesmusic.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val id: String,
    private val apiService: ApiService
): ViewModel() {

    private val isLoading = MutableStateFlow(false)
    private val article = MutableStateFlow<Article?>(null)

    val state = MutableStateFlow(State())

    init {
        viewModelScope.launch {
            combine(
                isLoading,
                article
            ) { isLoading, article ->
                State(isLoading, article)
            }.collect { state.value = it }
        }
        getArticle()
    }

    private fun getArticle() {
        viewModelScope.launch {
            isLoading.value = true
            runCatching { article.value = apiService.getArticles().find { it.url == id } }
            isLoading.value = false
        }
    }

    data class State(
        val isLoading: Boolean = false,
        val article: Article? = null
    )

}

class Factory(
    private val id: String,
    private val apiService: ApiService
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(classModel: Class<T>): T {
        return classModel.getConstructor(String::class.java, ApiService::class.java)
            .newInstance(id, apiService)
    }
}