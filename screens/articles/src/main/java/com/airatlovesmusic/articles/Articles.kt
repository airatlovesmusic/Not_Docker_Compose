package com.airatlovesmusic.articles

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.airatlovesmusic.core_network.ApiClient
import com.airatlovesmusic.model.Article
import com.airatlovesmusic.ui.toolbar
import com.airatlovesmusic.core_common.Screens
import org.koin.androidx.compose.get

@Composable
fun Articles(
    navigateTo: (Screens) -> Unit,
    apiClient: ApiClient = get()
) {
    val viewModel: ArticlesViewModel = viewModel(factory = Factory(apiClient))
    val viewState = viewModel.state.collectAsState()
    Scaffold(
        topBar = { toolbar("Articles") },
        bodyContent = { ArticlesContent(viewState, navigateTo) },
    )
}

@Composable
private fun ArticlesContent(
    viewState: State<ArticlesViewModel.State>,
    navigateTo: (Screens) -> Unit
) {
    if (viewState.value.isRefreshing) {
        CircularProgressIndicator()
    }
    LazyColumnFor(items = viewState.value.articles) { item ->
        ArticleItem(navigateTo, item)
    }
}

@Composable
private fun ArticleItem(
    navigateTo: (Screens) -> Unit,
    item: Article
) {
    Column(
        modifier = Modifier
            .clickable { navigateTo.invoke(Screens.Article(item.url)) }
            .padding(16.dp)
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = item.url,
            style = MaterialTheme.typography.subtitle1
        )
    }
    Divider()
}