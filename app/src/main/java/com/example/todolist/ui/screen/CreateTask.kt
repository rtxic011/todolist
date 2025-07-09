package com.example.todolist.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import com.example.todolist.ui.theme.ColorEnum
import com.example.todolist.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.navigation.NavHostController
import android.graphics.Color as AndroidColor
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch





//fun String.toColor(): Color {
//    return Color(AndroidColor.parseColor(this))
//}

val WhatColor = OpenColor
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateTask(navController: NavHostController) {
//    val WhatColor = ColorEnum.Main.color.toColor()


    //ver1s
//    val today = remember {
//        val Date = SimpleDateFormat("E dd MMM yyyy", Locale.ENGLISH)
//        Date.format(Date())
//    }
    //ver2
    var text by remember { mutableStateOf("") }

    val Date = DateTimeFormatter.ofPattern("E dd MMM yyyy", Locale.ENGLISH)
    val today = remember {
        LocalDate.now().format(Date)
    }
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 24.dp),
                    decorationBox = { innerTextFidel ->
                        Row ( modifier = Modifier
//                            .fillMaxSize()
                            .width(327.dp)
//                            .height()
                        ){
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                            ){
                                if (text.isEmpty()) {
                                    Text("eg : Meeting with client", color = Color)
                                }
                            }
                        }
                    }
                )
            }
        }
    ) {

        Scaffold(
            //글자들
            topBar = {
                Box(
                    modifier = Modifier
//                .fillMaxSize()
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 68.dp)
                            .width(327.dp)
                            .height(57.dp)
                            .align(Alignment.Center)
//                        .align(Alignment.CenterVertically)
                    ) {
                        Column(
                            modifier = Modifier
//                    .padding(start = 24.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "Today",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Best platform for creating to-do lists",
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
                }
            },
            //task
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
//                .padding(start = 24.dp, top = 30.dp)
                        .padding(top = 30.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(327.dp)
                            .height(148.dp)
                            .align(Alignment.CenterHorizontally)
                            .shadow(8.dp, shape = RoundedCornerShape(10.dp))
                            .background(Color.White, shape = RoundedCornerShape(10.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .width(327.dp)
                                .height(36.dp)
//                        .align(Alignment.TopStart)
                                .background(
                                    WhatColor,
                                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                                )
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
                            Row(
                                modifier = Modifier
//                            .size(28.dp)
                                    .height(28.dp)
//                            .padding(top = )
                                    .clickable { coroutineScope.launch { bottomSheetState.show() } }
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_plus),
                                        contentDescription = "plus",
                                        modifier = Modifier
                                            .size(23.33.dp)
//                                    .align(Alignment.Center)
                                            .align(Alignment.Center),
                                        tint = WhatColor
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Tap plus to create a new task ",
                                    style = TextStyle(

                                    ),
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .width(295.dp)
                                    .height(20.dp)
                                    .align(Alignment.BottomCenter)
                            ) {
                                Text(
                                    text = "Add your task",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        color = Color(red = 118, green = 126, blue = 140)
                                    ), modifier = Modifier
//                                    .align(Alignment.CenterVertically)
                                        .align(Alignment.CenterStart)
                                )
                                Spacer(modifier = Modifier.width(96.dp))
                                Text(
                                    text = "Today ∙ $today",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        color = Color(red = 118, green = 126, blue = 140)
                                    ), modifier = Modifier
                                        .align(Alignment.CenterEnd)
//                                    .align(Alignment.CenterVertically)
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
//                    .width(375.dp)
//                    .height(88.dp)
                        .fillMaxSize()
//                    .shadow(8.dp)
                ) {
                    Box(
                        modifier = Modifier
//                        .width(375.dp)
                            .height(88.dp)
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .shadow(8.dp)
                            .background(Color.White)
                    ) {
                    }
                }

            }
        )
    }
}



////추가 바
//@Composable
//fun CreatePlans() {
//    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
//    ModalBottomSheetLayout(
//        sheetState = bottomSheetState,
//        sheetContent = {
//            Text("Helloworld")
//        }
//    ) { }
//}

//@Preview(showBackground = true)
//@Composable
//fun PreviewCT() {
//}
