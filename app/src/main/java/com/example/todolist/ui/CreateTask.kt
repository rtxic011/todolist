package com.example.todolist.ui

import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.LineHeightStyle
import com.example.todolist.R
import com.example.todolist.ui.OpenColor
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale



var OpColor = Color(36, 161, 156)

@Composable
fun CT(WhatColor: Color) {
    //ver1
//    val today = remember {
//        val Date = SimpleDateFormat("E dd MMM yyyy", Locale.ENGLISH)
//        Date.format(Date())
//    }
    //ver2
    val today = remember {
        val Date = DateTimeFormatter.ofPattern("E dd MMM yyyy", Locale.ENGLISH)
        LocalDate.now().format(Date)
    }
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
//                Spacer(modifier = Modifier.height(30.dp))
            }
        },
        //task
        content = { innerPadding ->
            Column ( modifier = Modifier
                .padding(innerPadding)
                .padding(start = 24.dp, top = 30.dp)
            ){
                Column(modifier = Modifier
                    .width(327.dp)
                    .height(148.dp)
                    .shadow(8.dp, shape = RoundedCornerShape(10.dp))
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                ) {
                    Box(modifier = Modifier
                        .width(327.dp)
                        .height(36.dp)
//                        .align(Alignment.TopStart)
                        .background(WhatColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .width(295.dp)
                            .height(80.dp)
                            .align(Alignment.CenterHorizontally)
//                            .padding(top = 16.dp, start = 16.dp)
//                            .background(Color.Blue)
                    ) {
                        Row (modifier = Modifier
//                            .size(28.dp)
                            .height(28.dp)
//                            .padding(top = )
                        ) {
                            Box(modifier = Modifier
                                .size(28.dp)
                            ) {
                                Icon( painter = painterResource(id = R.drawable.icon_plus),
                                    contentDescription = "plus",
                                    tint = WhatColor,
                                    modifier = Modifier
                                        .size(23.33.dp)
//                                    .align(Alignment.Center)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Tap plus to create a new task ",
                                style = TextStyle(

                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                        }
                        Row (modifier = Modifier
                            .width(295.dp)
                            .height(20.dp)
                            .align(Alignment.BottomCenter)
                        ) {
                            Text(text = "Add your task",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    color = Color(red = 118, green = 126, blue = 140)
                                )
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "Today ∙ $today",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    color = Color(red = 118, green = 126, blue = 140)
                                ), modifier = Modifier
                                    .align(Alignment.CenterEnd)
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCT() {
    CT(OpColor)
}