package com.airatlovesmusic.compose.screens.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.airatlovesmusic.core_network.ApiService
import com.airatlovesmusic.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val apiService: ApiService
): ViewModel() {

    private val refreshing = MutableStateFlow(false)
    private val articles = MutableStateFlow(listOf<Article>())

    val state = MutableStateFlow(State())

    init {
        viewModelScope.launch {
            combine(refreshing, articles) { refreshing, articles ->
                State(refreshing, articles)
            }.collect { state.value = it }
        }
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            refreshing.value = true
            // TODO Error handling
            runCatching { articles.value = apiService.getArticles() }
            refreshing.value = false
        }
    }

    data class State(
        val isRefreshing: Boolean = false,
        val articles: List<Article> = listOf()
    )

}

class Factory(
    private val apiService: ApiService
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ApiService::class.java)
            .newInstance(apiService)
    }
}