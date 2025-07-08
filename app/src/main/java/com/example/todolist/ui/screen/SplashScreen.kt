package com.example.todolist.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import com.example.todolist.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("Theme") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Scaffold (
        containerColor = Color.Transparent,
        content = { innerPadding ->
            Column (modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(red = 36, green = 161, blue = 156))
            ){
                // 로고와 글씨
                Column (
                    modifier = Modifier
                        .padding(top = 300.dp)
                        .fillMaxSize()
                ) {
                    //휜상자
                    Box (
                        modifier = Modifier
                            .width(68.dp)
                            .height(68.dp)
                            .align(Alignment.CenterHorizontally)
//                            .align(Alignment.CenterHorizontally)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                    ) {
                        Box (
                            modifier = Modifier
                                .width(45.dp)
                                .height(45.dp)
                                .align(Alignment.Center)
                        ){
                            //체크
                            Column (
                                modifier = Modifier
                                    .padding( 5.dp, 0.dp, 2.25.dp, 0.dp)
                            ){
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_check),
                                    contentDescription = "check1",
                                    tint = Color(red = 36, green = 161, blue = 156),
                                    modifier = Modifier
                                        .width(12.dp)
                                        .height(12.dp)
                                )

                                Spacer(modifier = Modifier.height(4.5.dp))

                                Icon(
                                    painter = painterResource(id = R.drawable.icon_check),
                                    contentDescription = "check2",
                                    tint = Color(red = 36, green = 161, blue = 156),
                                    modifier = Modifier
                                        .width(12.dp)
                                        .height(12.dp)
                                )

                                Spacer(modifier = Modifier.height(4.5.dp))

                                Icon(
                                    painter = painterResource(id = R.drawable.icon_check),
                                    contentDescription = "check2",
                                    tint = Color(red = 36, green = 161, blue = 156),
                                    modifier = Modifier
                                        .width(12.dp)
                                        .height(12.dp)
                                )
                            }
                            Column (
                                modifier = Modifier
                                    .padding( 21.dp, 4.5.dp, 0.dp, 0.dp)
                            )
                            {
                                Box(modifier = Modifier
                                    .width(20.dp)
                                    .height(3.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color(red = 36, green = 161, blue = 156))
                                )

                                Spacer(modifier = Modifier.height(13.5.dp))

                                Box(modifier = Modifier
                                    .width(20.dp)
                                    .height(3.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color(red = 36, green = 161, blue = 156))
                                )

                                Spacer(modifier = Modifier.height(13.5.dp))

                                Box(modifier = Modifier
                                    .width(20.dp)
                                    .height(3.dp)
//                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color(red = 36, green = 161, blue = 156), shape = RoundedCornerShape(10.dp))
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    //글자상자
                    Column (modifier = Modifier
                        .align(Alignment.CenterHorizontally)
//                        .align(Alignment.CenterHorizontally)
//                        .width(213.dp)
//                        .height(62.dp)
                        .fillMaxWidth()
                    ) {
                        Text(text = "Todyapp",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text( text = "The best to do list application for you",
                              style = TextStyle(
                                  color = Color.White,
                                  fontSize = 14.sp
                              ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                            )
                    }
                }

            }
        }
    )
}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewIntroduceMe() {
//    FirstScreen()
//}