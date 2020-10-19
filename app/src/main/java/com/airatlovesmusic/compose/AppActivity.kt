package com.airatlovesmusic.compose

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.airatlovesmusic.core_network.ApiClient
import com.airatlovesmusic.core_network.ApiClientImpl
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