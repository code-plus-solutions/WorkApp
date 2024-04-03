package com.example.workapp.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workapp.R
import com.example.workapp.ui.theme.blue500
import com.example.workapp.ui.theme.liteGray
import com.example.workapp.ui.theme.red

@Composable
fun EditText(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    label: String,
    isError: Boolean = false,
    painter: Painter? = null,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        readOnly = readOnly,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        enabled = !readOnly,
        textStyle = TextStyle.Default.copy(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
        ),
        label = {
            Text(
                text = label, fontSize = 14.sp, color = Color.Black, fontFamily = FontFamily(
                    Font(R.font.iranyekanwebregular)
                )
            )
        },
        placeholder = {
            Text(
                text = hint,
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular)),
                color = liteGray
            )
        },
        singleLine = true,
        shape = CircleShape,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = blue500,
            unfocusedBorderColor = liteGray,
            errorBorderColor = red,
            disabledContainerColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        trailingIcon = {
            painter?.let {
                Icon(
                    modifier = Modifier.padding(
                        end = 14.dp
                    ),
                    painter = it,
                    contentDescription = label,
                    tint = Color.Unspecified
                )
            }
        }, isError = isError
    )
}

@Preview(name = "EditText")
@Composable
private fun PreviewEditText() {
    EditText(value = "aaa", hint = "aa", label = "aaa") {

    }
}