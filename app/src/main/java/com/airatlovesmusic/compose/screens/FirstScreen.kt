package com.airatlovesmusic.compose.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airatlovesmusic.compose.widgets.simpleToolbar

@Composable
fun FirstScreen(goToSecondScreen: () -> Unit) {
    Scaffold(
        topBar = { simpleToolbar("Compose App") { goToSecondScreen.invoke() } },
        bodyContent = {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                horizontalGravity = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Hello world!",
                    style = typography.h4
                )
                Button(onClick = goToSecondScreen) {
                    Text(text = "Click Me")
                }
            }
        },
    )
}