package com.airatlovesmusic.compose

import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.airatlovesmusic.compose.utils.getMutableStateOf
import com.airatlovesmusic.core_common.Screens
import com.airatlovesmusic.core_common.toBundle
import com.airatlovesmusic.core_common.toScreen

class NavigationViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var currentScreen: Screens by savedStateHandle.getMutableStateOf(
        key = SCREEN_KEY,
        default = Screens.Articles,
        save = { it.toBundle() },
        restore = { it.toScreen() }
    )
    private set

    @MainThread
    fun onBack(): Boolean {
        val wasHandled = currentScreen != Screens.Articles
        currentScreen = Screens.Articles
        return wasHandled
    }

    @MainThread
    fun navigateTo(screen: Screens) {
        currentScreen = screen
    }

    companion object {
        const val SCREEN_KEY = "screen_key"
    }

}