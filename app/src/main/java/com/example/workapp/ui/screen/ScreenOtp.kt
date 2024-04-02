package com.example.workapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.workapp.R
import com.example.workapp.ui.component.Button
import com.example.workapp.ui.component.OtpInputField
import com.example.workapp.ui.theme.blue50
import com.example.workapp.ui.theme.darkGray
import com.example.workapp.ui.theme.liteGray
import kotlinx.coroutines.delay


@Composable
fun ScreenOtp(
    modifier: Modifier = Modifier,
    ) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.backgrand_otp),
            contentDescription = "Otp"
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 60.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(blue50),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                text = "ورود/ثبت نام",
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular)),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.size(60.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                text = "کد ارسال شده به شماره ۰۹۱۳۶۴۸۴۴۵۷ را وارد کنید:",
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular)),
                fontSize = 14.sp,
                color = darkGray
            )
            val showKeyboard = remember { mutableStateOf(true) }
            val focusRequester = remember { FocusRequester() }
            val keyboardController = LocalSoftwareKeyboardController.current
            var isOtpFilled by remember { mutableStateOf(false) }
            Spacer(modifier = Modifier.size(30.dp))
            var code by remember { mutableStateOf("") }
            OtpInputField(
                modifier = Modifier.focusRequester(focusRequester),
                otpText = code,
                otpLength = 4
            ) { it, _ ->
                code = it
                if (code.length == 4) {
                    keyboardController?.hide()
                    isOtpFilled = true
                }
            }
            LaunchedEffect("") {
                focusRequester.requestFocus()
                keyboardController?.show()
            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(modifier = Modifier.padding(16.dp), text = "ثبت نام") {

            }
            Spacer(modifier = Modifier.size(15.dp))
            Text(modifier = Modifier.clickable{},
                text = "تغییر شماره",
                color = Color(0xFF5BB1FD),
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
            )
            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "ارسال مجدد پس از : ۱:۴۰",
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
            )
        }
    }
}

@Preview(name = "ScreenOtp")
@Composable
private fun PreviewScreenOtp() {
    ScreenOtp()
}