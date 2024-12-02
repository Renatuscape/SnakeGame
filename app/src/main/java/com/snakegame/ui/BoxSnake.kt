package com.snakegame.ui

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.geometry.Offset

@Composable
fun BoxSnake() {
    var offset by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    offset += dragAmount
                }
            },
        contentAlignment = Alignment.Center // Start at center
    ) {
        Box(
            modifier = Modifier
                .offset(offset.x.dp, offset.y.dp)
                .size(32.dp)
                .background(Color.Black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSwipeBox() {
    BoxSnake()
}