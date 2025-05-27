package com.example.todolist.ui

import android.R.attr.textStyle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

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
    Scaffold (
        topBar = {
            Column ( ) {
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
        }
    )
    { innerPadding ->
        Column (modifier = Modifier) {

        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewIntroduceMe() {
    Title()
}