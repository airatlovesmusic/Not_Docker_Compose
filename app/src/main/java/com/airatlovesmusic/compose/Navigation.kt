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
private const val ARG_ARTICLE_ID = "article_id"

enum class ScreenName {
    ARTICLES, ARTICLE
}

sealed class Screens(val id: ScreenName) {
    object Articles: Screens(ScreenName.ARTICLES)

    data class Article(
        val articleId: String
    ): Screens(ScreenName.ARTICLE)
}

fun Screens.toBundle() =
    bundleOf(SCREEN_NAME to id.name).also {
        if (this is Screens.Article) {
            it.putString(ARG_ARTICLE_ID, articleId)
        }
    }

fun Bundle.toScreen(): Screens =
    when (getString(SCREEN_NAME)) {
        ScreenName.ARTICLES.name -> Screens.Articles
        ScreenName.ARTICLES.name -> Screens.Article(getString(ARG_ARTICLE_ID, ""))
        else -> throw Exception("Screen haven't found")
    }

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