package com.example.todolist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.R
import com.example.todolist.ui.OpenColor


@Composable
fun CT(color: Color) {
    Scaffold (
        //글자들
        topBar = {
            Row (modifier = Modifier
                .padding(top = 68.dp)
                .width(327.dp)
                .height(57.dp)
            ) {
                Column (modifier = Modifier
                    .padding(start = 24.dp)
                ) {
                    Text( text = "Today",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Best platform for creating to-do lists",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(red = 118, green = 126, blue = 140)
                        ), modifier = Modifier
//                            .align(Alignment.BottomStart)
                    )
                }
//                Icon(
//                    painter = painterResource(id = R.drawable.icon_check),
//                    contentDescription = "check",
//                    tint = Color.White,
//                    modifier = Modifier
////                            .padding(start = 10.dp)
//                        .align(Alignment.Center)
//                        .size(20.dp)
//                )
                //설정 아이콘
                Icon(
                    painter = painterResource(id = R.drawable.icon_settings),
                    contentDescription = "setting",
                    tint = Color(118, 126, 140),
                    modifier = Modifier
                        .padding(top = 2.dp, start = 50.dp)
//                        .width(19.dp)
//                        .height(20.dp)
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
            }
        },
        //task
        content = { innerPadding ->
            Column (
                modifier = Modifier.padding(innerPadding)
            ){

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCT() {
    CT(OpenColor)
}