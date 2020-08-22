package com.airatlovesmusic.compose.widgets

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.contentColor
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun simpleToolbar(title: String, onNavigationIconClick: () -> Unit = {}) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(Icons.Filled.ArrowBack)
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                color = contentColor()
            )
        }
    )
}