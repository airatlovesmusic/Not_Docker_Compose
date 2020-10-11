package com.airatlovesmusic.compose.screens.articles

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.airatlovesmusic.compose.Screens
import com.airatlovesmusic.compose.widgets.toolbar
import com.airatlovesmusic.core_network.ApiService
import com.airatlovesmusic.model.Article

val articles = (0..10).map {
    Article(
        title = "title$it",
        url = "url$it"
    )
}

@Composable
fun Articles(navigateTo: (Screens) -> Unit, apiService: ApiService) {
    val viewModel: ArticlesViewModel = viewModel(factory = Factory(apiService))
    val viewState = viewModel.state.collectAsState()
    Scaffold(
        topBar = { toolbar("Articles") },
        bodyContent = {
            if (viewModel.state.value.isRefreshing) {
                CircularProgressIndicator()
            }
            ScrollableColumn(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                viewState.value.articles.forEach {
                    Column(
                        modifier = Modifier
                            .clickable(onClick = { navigateTo.invoke(Screens.Article(it.url)) })
                    ) {
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
        },
    )
}