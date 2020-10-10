package com.airatlovesmusic.compose.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airatlovesmusic.compose.widgets.toolbar

@Composable
fun SecondScreen(goToFirstScreen: () -> Unit) {
    Scaffold(
        topBar = { toolbar("Compose App") { goToFirstScreen.invoke() } },
        bodyContent = {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                horizontalGravity = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Second Screen!",
                    style = MaterialTheme.typography.h4
                )
                Button(onClick = goToFirstScreen) {
                    Text(text = "Click Me")
                }
            }
        }
    )
}