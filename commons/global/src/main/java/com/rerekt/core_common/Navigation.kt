package com.rerekt.core_common

import android.os.Bundle
import androidx.core.os.bundleOf

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