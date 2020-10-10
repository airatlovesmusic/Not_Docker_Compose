package com.airatlovesmusic.compose.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airatlovesmusic.compose.widgets.toolbar
import com.airatlovesmusic.model.Article

val articles = (0..10).map {
    Article(
        title = "title$it",
        url = "url$it"
    )
}

@Composable
fun FirstScreen(goToSecondScreen: () -> Unit) {
    Scaffold(
        topBar = { toolbar("Compose App") { goToSecondScreen.invoke() } },
        bodyContent = {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                articles.forEach {
                    Column {
                        Text(it.title)
                        Text(it.url)
                    }
                }
                Button(onClick = goToSecondScreen) {
                    Text(text = "Click Me")
                }
            }
        },
    )
}