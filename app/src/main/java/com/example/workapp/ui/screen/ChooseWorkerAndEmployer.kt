package com.example.workapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workapp.R
import com.example.workapp.ui.component.Button
import com.example.workapp.ui.theme.blue500

@Composable
fun ChooseWorkerAndEmployer(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.backgrand_choose_worker_emploeyer),
            contentDescription = ""
        )
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "ورود/ثبت نام",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.iranyekanwebbold))
            )
            Spacer(modifier = modifier.size(54.dp))
            Text(
                text = " به دنبال یک فرصت شغلی جذاب و مناسبی؟",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
            )
            Row {
                Card(
                    modifier = Modifier,
                    colors = CardDefaults.cardColors(containerColor = blue500),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Box {
                        Text(
                            text = "کارشورو",
                            color = Color.White,
                            modifier = Modifier.padding(10.dp, 0.dp),
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
                        )
                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = "از دست نده",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.iranyekanwebregular))
                )
            }
            Spacer(modifier = modifier.size(84.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(36.dp, 0.dp),
                text = "کارفرما هستم",
                icon = painterResource(id = R.drawable.worker)
            ) {

            }
            Spacer(modifier = modifier.size(44.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(36.dp, 0.dp),
                text = "کارگر هستم",
                icon = painterResource(id = R.drawable.employer)
            ) {

            }
        }
    }
}

@Preview(name = "ChooseWorkerAndEmployer", showBackground = true)
@Composable
private fun PreviewChooseWorkerAndEmployer() {
    ChooseWorkerAndEmployer()
}