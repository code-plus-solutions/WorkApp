package com.example.workapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workapp.R
import com.example.workapp.ui.component.Button
import com.example.workapp.ui.component.EditText
import com.example.workapp.ui.component.ImageUploader
import com.example.workapp.ui.component.RadioButton
import com.example.workapp.ui.theme.blue200
import com.example.workapp.ui.theme.darkGray
import com.example.workapp.ui.theme.liteGray

@Composable
fun ScreenWorkerRegister(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(color = blue200)
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "ثبت نام کارگر",
            fontFamily = FontFamily(Font(R.font.iranyekanwebbold)),
            fontSize = 24.sp
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .background(Color.White),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(26.dp),
                text = "جهت ثبت نام اطلاعات خود را وارد کنید:",
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular)),
                fontSize = 14.sp,
                color = darkGray
            )
            var name by remember { mutableStateOf("") }
            EditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                value = name,
                hint = "مثال : احسان مرادی",
                label = "نام نام خانوادگی"
            ) {
                name = it
            }
            Spacer(modifier = Modifier.size(36.dp))
            var phone by remember { mutableStateOf("09136978682") }
            EditText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                value = phone,
                hint = "",
                readOnly = true,
                label = "شماره تماس",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                painter = painterResource(id = R.drawable.iran_flag)
            ) {
                phone = it
            }

            //Todo: Add adress

            Spacer(modifier = Modifier.size(36.dp))
            var man by remember { mutableStateOf(true) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "جنسیت :",
                    fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
                )
                Spacer(modifier = Modifier.size(height = 0.dp, width = 160.dp))
                RadioButton(checked = man, text = "مرد") {
                    man = it
                }
                Spacer(modifier = Modifier.size(16.dp))
                RadioButton(checked = !man, text = "زن") {
                    man = !it
                }
            }
            Spacer(modifier = Modifier.size(26.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                text = "عکس پروفایل :",
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                text = "در صورتی که عکس پروفایل داشته باشی شانس بیشتری برای انتخاب شدن داری",
                color = liteGray,
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
            )
            ImageUploader(modifier = Modifier.padding(16.dp)) {

            }
            Spacer(modifier = Modifier.size(30.dp))
            Button(modifier = Modifier.padding(16.dp), text = "ثبت نام") {

            }
            Spacer(modifier = Modifier.size(30.dp))

        }
    }
}

@Preview(name = "WorkerRegister",)
@Composable
private fun PreviewWorkerRegister() {
    ScreenWorkerRegister()
}