package com.example.todolist.ui

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.todolist.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview


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

////체크상자
//Box(
//modifier = Modifier
//.fillMaxSize()
////                     .padding(innerPadding)
//) {
//    Box(
//        modifier = Modifier
//            .align(Alignment.TopStart)
//            .padding(20.dp, 165.dp, 0.dp, 0.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .width(32.dp)
//                .height(32.dp)
//                .clip(CircleShape)
//                .background(Color(red = 36, green = 161, blue = 156))
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.icon_check),
//                contentDescription = "check",
//                tint = Color.White,
//                modifier = Modifier
//                    //                            .fillMaxSize()
//                    .align(Alignment.Center)
//                    .width(12.dp)
//                    .height(12.dp)
//            )
//        }
//    }
//}

var OpenColor = Color(36, 161, 156)

val colors = listOf(
    Color(36, 161, 156),
    Color.Black,
    Color(234, 67, 53),
    Color(24, 119, 242)
)


@Composable
fun Running() {
    var selectedColor by remember { mutableStateOf<Color?>(null) }

//    Scaffold { innerPadding ->
        Column(modifier = Modifier
            //.padding(innerPadding)
//            .fillMaxWidth()
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
                Title()
                Spacer(modifier = Modifier.height(15.dp))
//                aaa(headColor = Color(36, 161, 156)) // 초록상자
//                Spacer(modifier = Modifier.height(16.dp))
//                aaa(headColor = Color.Black) // 검정상자
//                Spacer(modifier = Modifier.height(16.dp))
//                aaa(headColor = Color(234, 67, 53)) // 빨강상자
//                Spacer(modifier = Modifier.height(16.dp))
//                aaa(headColor = Color(24, 119, 242)) // 파랑상자
                colors.forEach { color ->
                    ColorBoxs (
                        headColor = color,
                        isSelected = (selectedColor == color),
                        onClick = { selectedColor = color }
                    )
//                    Spacer(modifier = Modifier.height(16.dp))
                }
            Spacer(modifier = Modifier.height(130.dp))
            boxfordecision(OpenColor)
        }
    }
//}

@Composable
fun Title() {
//    Scaffold(
    Column (modifier = Modifier.background(Color.White)) {
        //상자 위에 있는 글씨 2줄
//        topBar = {
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
                    .padding(top = 5.dp)
//                    .offset(y = 5.dp)
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
        }
//        },
//     content = { innerPadding ->
//         }
//    )
}

@Composable
fun ColorBoxs(
    headColor: Color,
    isSelected : Boolean,
    onClick: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
//            .align(Alignment.CenterHorizontally)
                .align(Alignment.Center)
            .padding(top = 16.dp)
//            .fillMaxWidth()
                .clickable { onClick() },
//        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 머리
            Box(
                modifier = Modifier
                    .width(327.dp)
                    .height(36.dp)
                    .align(Alignment.CenterHorizontally)
//                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    .background(headColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            ) {
            }

            // 몸통
            Box(
                modifier = Modifier
                    .width(327.dp)
                    .height(68.dp)
                    .shadow(10.dp)
//                    .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                    .background(Color.White, shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp, 16.dp, 0.dp, 0.dp)
                ) {
                    // 동그라미
                    Box(
                        modifier = Modifier
                            .size(34.dp)
//                            .clip(CircleShape)
                            .background(Color(231, 236, 245), shape = CircleShape)
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 80.dp)
                ) {
                    listOf(185.dp, 128.dp, 156.dp).forEach {
                        Box(
                            modifier = Modifier
                                .width(it)
                                .height(5.dp)
//                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(231, 236, 245), shape = RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(50.dp, 5.dp, 0.dp, 0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
//                            .clip(CircleShape)
//                    .background(Color(red = 36, green = 161, blue = 156))
                            .background(headColor, shape = CircleShape)
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.icon_check),
                            contentDescription = "check",
                            tint = Color.White,
                            modifier = Modifier
//                            .padding(start = 10.dp)
                                .align(Alignment.Center)
                                .size(20.dp)
                        )
                    }
                    OpenColor = headColor
                }
            }
    }
}


@Composable
fun boxfordecision (
    headColor : Color
) {
    Box(modifier = Modifier
        .width(327.dp)
        .height(56.dp)
        .clip(RoundedCornerShape(10.dp))
//        .background(Color(36, 161, 156))
        .background(headColor)
    ){
        Text(text = "Open Todyapp",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewTheme() {
    Running()
}