package com.example.workapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.workapp.R

@Composable
fun RadioButton(
    modifier: Modifier = Modifier,
    checked: Boolean,
    text: String? = null,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { onCheckedChange(!checked) }) {
            Icon(
                painter = if (checked) painterResource(id = R.drawable.radio_check) else painterResource(
                    id = R.drawable.radio_uncheck
                ),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
        if (text != null) {
            Text(text = text, fontFamily = FontFamily(Font(R.font.iranyekanwebregular)))
        }

    }
}

@Preview(name = "RadioButton")
@Composable
private fun PreviewRadioButton() {
    RadioButton(checked = false){

    }
}