package com.airatlovesmusic.compose

import android.os.Bundle
import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.airatlovesmusic.compose.utils.getMutableStateOf

private const val SCREEN_NAME = "screen_name"

enum class ScreenName {
    FIRST, SECOND
}

sealed class Screens(val id: ScreenName) {
    object First: Screens(ScreenName.FIRST)
    object Second: Screens(ScreenName.SECOND)
}

fun Screens.toBundle() =
    bundleOf(SCREEN_NAME to id.name)

fun Bundle.toScreen(): Screens =
    when (getString(SCREEN_NAME)) {
        ScreenName.FIRST.name -> Screens.First
        ScreenName.FIRST.name -> Screens.Second
        else -> throw Exception("Screen haven't found")
    }

class NavigationViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var currentScreen: Screens by savedStateHandle.getMutableStateOf(
        key = SCREEN_KEY,
        default = Screens.First,
        save = { it.toBundle() },
        restore = { it.toScreen() }
    )
    private set

    @MainThread
    fun onBack(): Boolean {
        val wasHandled = currentScreen != Screens.First
        currentScreen = Screens.First
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