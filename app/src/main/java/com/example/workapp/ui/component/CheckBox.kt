package com.example.workapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
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
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean ,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { onCheckedChange(!checked) }) {
            Icon(
                painter = if (checked) painterResource(id = R.drawable.checkbox_check) else painterResource(
                    id = R.drawable.checkbox_uncheck
                ),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }

    }
}

@Preview(name = "CheckBox")
@Composable
private fun PreviewCheckBox() {
    CheckBox(checked = true) {}
}