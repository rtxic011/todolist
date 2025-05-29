package com.example.todolist.ui

import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import com.example.todolist.R

//@Composable
//fun Title () { val insetPadding = WindowInsets.safeDrawing.asPaddingValues()
//    Box (modifier = Modifier
//        .padding(insetPadding)
//        .
//    )
//    {
//        Text(
//            text = "To do list",
//            style = TextStyle(
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//
//            )
//        )
//    }
//}

@Composable
fun Title() {
    Scaffold(
        modifier = Modifier.background(Color.White),
        //상자 위에 있는 글씨 2줄
        topBar = {
            Column() {
                Text(
                    text = "Create to do list",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .padding(top = 100.dp)
//                        .offset(y=)
                        .fillMaxWidth()
                )
                Text(
                    text = "Choose your to do list color theme:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    ),
                    modifier = Modifier
                        .offset(y = 5.dp)
                        .fillMaxWidth()
                )
//                Box(modifier = Modifier
//                    .fillMaxWidth()
//                ) {
//                    var text by remember { mutableStateOf("") }
//                    OutlinedTextField (
//                        value = text,
//                        onValueChange = { text = it },
//                        label = { Text("한마디를 입력하세요.") },
//                        textStyle = TextStyle (
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.SemiBold,
//                            textAlign = TextAlign.Center
//                        ),
//                        modifier = Modifier
//                            .offset(y = 5.dp)
//                            .align(Alignment.Center)
////                        .fillMaxWidth()
//                    )
//                }
            }
        },
     content = { innerPadding ->
        //상자들
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
//                .align(Alignment.Center)
                .padding(35.dp, 30.dp, 0.dp, 0.dp)
        ) {
            //큰 배경1
            Column(
                modifier = Modifier
//                    .padding(innerPadding)
//            .fillMaxWidth()
//            .fillMaxHeight()
//                    .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                    .clickable {
                        //체크상자1
                        Box(modifier = Modifier
                            .fillMaxSize()
                        ) {
                            Box(modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(20.dp, 165.dp, 0.dp, 0.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(32.dp)
                                        .height(32.dp)
                                        .clip(CircleShape)
                                        .background(Color(red = 36, green = 161, blue = 156))
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_check),
                                        contentDescription = "check",
                                        tint = Color.White,
                                        modifier = Modifier
//                            .fillMaxSize()
                                            .align(Alignment.Center)
                                            .width(12.dp)
                                            .height(12.dp)
                                    )
                                }
                            }
                        }
                    }
            ) {
                //초록상자 머리
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(36.dp)
//                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
//                        .align(Alignment.CenterStart)
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(
                            Color(red = 36, green = 161, blue = 156)
                        )
                ) {
//                Text("")
                    Spacer(modifier = Modifier.fillMaxSize())
                }
                //초록상자 몸통
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(68.dp)
//                .padding(0.dp, 30.dp, 0.dp, 0.dp)
//                            .align(Alignment.CenterHorizontally)
//                        .align(Alignment.CenterStart)

                        // shadow 제대로 적용이 안되는 중.
                        .shadow(10.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )

                        .background(Color.White)

                ) {
//                Text("")
//                    Spacer(modifier = Modifier.fillMaxSize())
                    //내부요소들
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp, 16.dp, 0.dp, 0.dp)
                    ) {
                        //동그라미
                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(34.dp)
                                .clip(CircleShape)
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
//                        .fillMaxSize()
//                        .width(185.dp)
//                        .height(31.dp)
                            .padding(80.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        //길다란거
                        Box(
                            modifier = Modifier
                                .width(185.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(128.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(156.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            //큰 배경2
            Column(
                modifier = Modifier
//                        .padding(innerPadding)
//                        .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                //검정상자 머리
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(36.dp)
//                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
//                        .align(Alignment.CenterStart)
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(Color.Black)
                ) {
//                Text("")
                    Spacer(modifier = Modifier.fillMaxSize())
                }
                //검정상자 몸통
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(68.dp)
//                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
//                        .align(Alignment.CenterStart)

                        // shadow 제대로 적용이 안되는 중.
                        .shadow(10.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )

                        .background(Color.White)

                ) {
//                Text("")
//                    Spacer(modifier = Modifier.fillMaxSize())
                    //내부요소들2
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp, 16.dp, 0.dp, 0.dp)
                    ) {
                        //동그라미
                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(34.dp)
                                .clip(CircleShape)
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
//                        .fillMaxSize()
//                        .width(185.dp)
//                        .height(31.dp)
                            .padding(80.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        //길다란거
                        Box(
                            modifier = Modifier
                                .width(185.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(128.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(156.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            //큰 배경3
            Column(
                modifier = Modifier
//                        .padding(innerPadding)
//                        .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                //빨간상자 머리
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(36.dp)
                        //                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
                        //                        .align(Alignment.CenterStart)
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(Color(red = 234, green = 67, blue = 53))
                ) {
                    //                Text("")
                    Spacer(modifier = Modifier.fillMaxSize())
                }
                //빨간상자 몸통
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(68.dp)
                        //                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
                        //                        .align(Alignment.CenterStart)

                        // shadow 제대로 적용이 안되는 중.
                        .shadow(10.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )

                        .background(Color.White)

                ) {
                    //                Text("")
                    //                    Spacer(modifier = Modifier.fillMaxSize())
                    //내부요소들2
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp, 16.dp, 0.dp, 0.dp)
                    ) {
                        //동그라미
                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(34.dp)
                                .clip(CircleShape)
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            //                        .fillMaxSize()
                            //                        .width(185.dp)
                            //                        .height(31.dp)
                            .padding(80.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        //길다란거
                        Box(
                            modifier = Modifier
                                .width(185.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(128.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(156.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            //큰 배경4
            Column(
                modifier = Modifier
//                        .padding(innerPadding)
//                        .fillMaxSize()
                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                //파란상자 머리
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(36.dp)
                        //                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
                        //                        .align(Alignment.CenterStart)
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(Color(red = 24, green = 119, blue = 242))
                ) {
                    //                Text("")
                    Spacer(modifier = Modifier.fillMaxSize())
                }
                //파란상자 몸통
                Box(
                    modifier = Modifier
                        .width(327.dp)
                        .height(68.dp)
                        //                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
                        //                        .align(Alignment.CenterStart)

                        // shadow 제대로 적용이 안되는 중.
                        .shadow(10.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 10.dp,
                                bottomEnd = 10.dp
                            )
                        )

                        .background(Color.White)

                ) {
                    //                Text("")
                    //                    Spacer(modifier = Modifier.fillMaxSize())
                    //내부요소들2
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp, 16.dp, 0.dp, 0.dp)
                    ) {
                        //동그라미
                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(34.dp)
                                .clip(CircleShape)
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        )
                    }
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            //                        .fillMaxSize()
                            //                        .width(185.dp)
                            //                        .height(31.dp)
                            .padding(80.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        //길다란거
                        Box(
                            modifier = Modifier
                                .width(185.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(128.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .width(156.dp)
                                .height(5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(red = 231, green = 236, blue = 245))
                        ) {}
                        }
                    }
                }
            }
        }
    )
}





@Preview(showBackground = true)
@Composable
fun PreviewIntroduceMe() {
    Title()
}