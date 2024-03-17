package com.example.workapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workapp.R
import com.example.workapp.ui.theme.blue500

@Composable
fun ImageUploader(
    modifier: Modifier = Modifier,
    painter: Painter? = null,
    onClick: () -> Unit
) {
    val stroke = Stroke(
        width = 4f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(18f, 18f), 0f)
    )
    Box(
        modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF5F5F5))
            .clickable { onClick() }
    ) {
        if (painter != null) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = ""
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.7.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color(0x591400FF),
                            cornerRadius = CornerRadius(8.dp.toPx()),
                            style = stroke
                        )
                    }
            ) {
                TextButton(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = { },
                    colors = ButtonDefaults.textButtonColors(contentColor = blue500)
                ) {
                    Text(
                        text = "افزودن عکس",
                        fontFamily = FontFamily(Font(resId = R.font.iranyekanwebregular))
                    )
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "add")
                }
            }

        }
    }
}

@Preview(name = "ImageUploader")
@Composable
private fun PreviewImageUploader() {
    ImageUploader() {

    }
}