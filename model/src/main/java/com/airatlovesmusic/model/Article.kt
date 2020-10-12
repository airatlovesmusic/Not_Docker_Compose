package com.airatlovesmusic.model

import kotlinx.serialization.Serializable

/**
 * Created by Airat Khalilov on 22/08/2020.
 */

@Serializable
data class Article(
    val title: String,
    val url: String
)