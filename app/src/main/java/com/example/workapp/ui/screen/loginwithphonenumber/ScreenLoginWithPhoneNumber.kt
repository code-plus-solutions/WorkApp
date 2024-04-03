package com.example.workapp.ui.screen.loginwithphonenumber

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.workapp.R
import com.example.workapp.ui.component.Button
import com.example.workapp.ui.component.EditText
import com.example.workapp.ui.theme.blue50

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ScreenLoginWithPhoneNumber(
    modifier: Modifier = Modifier,
    viewModel: LoginWithPhoneNumberViewModel  = hiltViewModel()
) {
    Box(
        modifier
            .fillMaxSize()
            .background(blue50)
    ) {
        IconButton(
            modifier = modifier.padding(top = 14.dp, start = 14.dp),
            onClick = viewModel::backTOChooseWorkerAndEmployer) {
            Icon(painter = painterResource(id = R.drawable.back), contentDescription = "back")
        }
        Column(
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ورود/ثبت نام",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.iranyekanwebbold))
            )
            Spacer(modifier = Modifier.size(54.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "جهت ثبت نام شماره تماس خود را وارد کنید:",
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular)),
            )

            val phone by viewModel.phone.collectAsState()
            val error by viewModel.error.collectAsState()
            EditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = phone,
                hint = "",
                isError = !error,
                label = "شماره تماس",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                painter = painterResource(id = R.drawable.iran_flag)
            ) {
                viewModel.updatePhone(it)
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "ورود/ثبت نام",
                onClick = viewModel::login
            )
        }
    }
}

@Preview(name = "LoginWithPhoneNumber", showBackground = true)
@Composable
private fun PreviewLoginWithPhoneNumber() {
    ScreenLoginWithPhoneNumber()
}