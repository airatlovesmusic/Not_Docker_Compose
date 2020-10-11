package com.airatlovesmusic.compose

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.airatlovesmusic.compose.screens.articles.Articles
import com.airatlovesmusic.compose.screens.article.Article
import com.airatlovesmusic.core_network.ApiService
import com.airatlovesmusic.core_network.getApiService

data class AppContext(
    val apiService: ApiService
)

class AppActivity: AppCompatActivity() {

    private val navigationViewModel by viewModels<NavigationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContext = AppContext(getApiService())
        setContent { App(appContext, navigationViewModel) }
    }

    override fun onBackPressed() {
        if (!navigationViewModel.onBack()) {
            super.onBackPressed()
        }
    }

    @Composable
    fun App(
        appContext: AppContext,
        navigationViewModel: NavigationViewModel
    ) {
        AppTheme {
            AppContent(
                appContext = appContext,
                navigationViewModel = navigationViewModel
            )
        }
    }

    @Composable
    private fun AppContent(
        appContext: AppContext,
        navigationViewModel: NavigationViewModel
    ) {
        Crossfade(navigationViewModel.currentScreen) { screen ->
            Surface(color = MaterialTheme.colors.background) {
                when (screen) {
                    is Screens.Articles ->
                        Articles(
                            navigateTo = navigationViewModel::navigateTo,
                            apiService = appContext.apiService
                        )
                    is Screens.Article ->
                        Article(
                            articleId = screen.articleId,
                            apiService = appContext.apiService,
                            goBack = navigationViewModel::onBack
                        )
                }
            }
        }
    }
}