package com.airatlovesmusic.compose

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.airatlovesmusic.article.Article
import com.airatlovesmusic.articles.Articles
import com.airatlovesmusic.core_common.Screens

@Composable
fun App(navigationViewModel: NavigationViewModel) {
    AppTheme {
        AppContent(navigationViewModel = navigationViewModel)
    }
}

@Composable
private fun AppContent(
    navigationViewModel: NavigationViewModel
) {
    Crossfade(navigationViewModel.currentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                is Screens.Articles ->
                    Articles(
                        navigateTo = navigationViewModel::navigateTo
                    )
                is Screens.Article ->
                    Article(
                        articleId = screen.articleId,
                        goBack = navigationViewModel::onBack
                    )
            }
        }
    }
}