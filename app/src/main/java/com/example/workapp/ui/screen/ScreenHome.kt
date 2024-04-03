package com.example.workapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScreenHome(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "ScreenHome")
    }
}

@Preview(name = "ScreenHome")
@Composable
private fun PreviewScreenHome() {
    ScreenHome()
}