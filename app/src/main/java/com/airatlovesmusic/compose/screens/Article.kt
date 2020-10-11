package com.airatlovesmusic.compose.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airatlovesmusic.compose.Screens
import com.airatlovesmusic.compose.widgets.toolbar

@Composable
fun Article(navigateTo: (Screens) -> Unit) {
    Scaffold(
        topBar = { toolbar("Article", true) { navigateTo(Screens.First) } },
        bodyContent = {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Second Screen!",
                    style = MaterialTheme.typography.h4
                )
                Button(
                    onClick = { navigateTo(Screens.First) }
                ) { Text(text = "Click Me") }
            }
        }
    )
}