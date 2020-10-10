package com.airatlovesmusic.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent
import com.airatlovesmusic.compose.screens.FirstScreen
import com.airatlovesmusic.compose.screens.SecondScreen

class AppActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }

    @Composable
    fun App() {
        AppTheme {
            AppContent()
        }
    }

    @Composable
    private fun AppContent() {
        val currentScreen = remember { mutableStateOf<Screens>(Screens.First) }
        Crossfade(currentScreen.value) { screen ->
            Surface(color = MaterialTheme.colors.background) {
                when (screen) {
                    is Screens.First -> FirstScreen { currentScreen.value = Screens.Second }
                    is Screens.Second -> SecondScreen { currentScreen.value = Screens.First }
                }
            }
        }
    }
}