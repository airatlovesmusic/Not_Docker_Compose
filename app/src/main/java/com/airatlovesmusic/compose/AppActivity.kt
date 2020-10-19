package com.airatlovesmusic.compose

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.airatlovesmusic.core_network.ApiClient
import com.airatlovesmusic.core_network.ApiClientImpl
import com.airatlovesmusic.articles.Articles
import com.airatlovesmusic.article.Article
import com.airatlovesmusic.core_common.Screens
import org.koin.androidx.compose.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class AppActivity: AppCompatActivity() {

    private val navigationViewModel by viewModels<NavigationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            module {
                single<ApiClient> { ApiClientImpl() }
            }
        }
        setContent { App(navigationViewModel) }
    }

    override fun onBackPressed() {
        if (!navigationViewModel.onBack()) {
            super.onBackPressed()
        }
    }
}