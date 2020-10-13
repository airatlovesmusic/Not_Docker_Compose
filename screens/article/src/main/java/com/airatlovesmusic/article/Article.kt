package com.airatlovesmusic.article

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.airatlovesmusic.ui.toolbarWithNavigationIcon
import com.airatlovesmusic.core_network.ApiClient

@Composable
fun Article(
    articleId: String,
    apiClient: ApiClient,
    goBack: () -> Unit
) {
    val viewModel: ArticleViewModel = viewModel(factory = Factory(articleId, apiClient))
    val viewState = viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            toolbarWithNavigationIcon("Article") { goBack() }
        },
        bodyContent = { ArticleContent(viewState) }
    )
}

@Composable
private fun ArticleContent(viewState: State<ArticleViewModel.State>) {
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        if (viewState.value.isLoading) {
            CircularProgressIndicator()
        }
        viewState.value.article?.let {
            Text(
                text = it.title,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = it.url,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}