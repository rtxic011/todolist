package com.example.todolist.ui.screen

//import android.app.TimePickerDialog
import android.os.Build
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.remember
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.rememberDatePickerState
//import androidx.compose.ui.Alignment
import java.text.SimpleDateFormat
import java.util.Date
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import java.time.DayOfWeek
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.material.Button
//import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.time.LocalTime
import java.util.Calendar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.ui.theme.TaskViewModel



data class Taskinfo(
    var title: String,
    var description: String,
    var dueTime: Long?,
    var dueMillis: Long?,
    var done: Boolean = false
)
//var taskList =remember { mutableStateListOf<Taskinfo>() }



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskCard(task: Taskinfo, whatColor: Color) { // whatColor를 그대로 유지했습니다.
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.getDefault())
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault())

    val dueDateString = task.dueMillis?.let { millis ->
        LocalDate.ofEpochDay(millis / (1000 * 60 * 60 * 24)).format(dateFormatter)
    } ?: "날짜 미정"

    val dueTimeString = task.dueTime?.let { millis ->
        java.time.Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalTime().format(timeFormatter)
    } ?: "시간 미정"

    Column(
        modifier = Modifier
            .width(327.dp)
            .height(148.dp)
            .shadow(8.dp, shape = RoundedCornerShape(10.dp))
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .background(whatColor, shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = task.title, fontWeight = FontWeight.Bold) // title은 이제 null이 아님
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = task.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "기한: $dueDateString", // 실제 날짜 표시
                style = TextStyle(fontSize = 12.sp, color = Color.Gray),
            )
            Text(
                text = "시간: $dueTimeString", // 실제 시간 표시
                style = TextStyle(fontSize = 12.sp, color = Color.Gray),
            )
        }
    }
}





//@Composable
//fun onReschedule() {
//
////    taskList.add(
////        Task(
////            title = "새로운 할 일",
////            dueTimeMillis = dateTimeMillis,
////            done = false
////        )
////    )
//}


// .clickable { coroutineScope.launch { bottomSheetState.show() } }

//fun convertMillisToDate(millis: Long): String {
//    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
//    return formatter.format(Date(millis))
//}

@Composable
fun QuickDatePicker(onQuickSelect: (Long) -> Unit) {
    val today = LocalDate.now()
//    var formatter = DateTimeFormatter.ofPattern("d MMM yyyy")

    val options = listOf(
        "Today" to today,
        "Tomorrow" to today.plusDays(1),
        "This weekend" to today.plusWeeks(1),
        "Next weekend" to today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).plusWeeks(1),
    )

    Column(Modifier.padding(horizontal = 16.dp)) {
        options.forEach { (label, date) ->
//            val dateStr = date.format(formatter)
            val formatter = when (label) {
                "Tomorrow", "This weekend" -> DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
                else -> DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onQuickSelect(
                            date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
                        )
                    }
                    .padding(vertical = 12.dp)
            ) {
                Icon(
                    imageVector = when (label) {
                        "Today" -> ImageVector.vectorResource(id =R.drawable.icon_sun)
                        "Tomorrow" -> ImageVector.vectorResource(id =R.drawable.icon_cloud)
                        "This weekend" -> ImageVector.vectorResource(id =R.drawable.icon_thisweekend)
                        "Next weekend" -> ImageVector.vectorResource(id =R.drawable.icon_nextweekend)
                        else -> ImageVector.vectorResource(id =R.drawable.icon_sun)
                    },
                    contentDescription = null
                )
                Spacer(Modifier.width(12.dp))
                Text(label, modifier = Modifier.weight(1f))
//                Tve file: EB%93%9C/To-do-list/app/src/main/java/com/example/todolist/ui/screen/CreateTask.kt:137:9 Unresolved reference 'QuichDatePicker'.
                val dateStr = date.format(formatter)
                Text(dateStr, color = Color.Gray)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal (
    onDismiss: () -> Unit,
    onDateSelected: (Long?) -> Unit
    ) {
    val dataPickerState = rememberDatePickerState()
//    val scope = rememberCoroutineScope()
    var showDatePicker = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var timepickerState = remember { mutableStateOf<LocalTime?>(null) }
    var whatTime = "Add Time"
    var showTimePicker by remember { mutableStateOf(false) }

//    var wantTimestate = remember { mutableStateOf<LocalTime?>(null) }
    var wantTimestate by remember { mutableStateOf(false) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = showDatePicker,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        QuickDatePicker( onQuickSelect = { millis ->
            onDateSelected(millis)
            onDismiss()
        } )
        Spacer(Modifier.height(24.dp))
        DatePicker(state = dataPickerState)
        Spacer(modifier = Modifier .height(13.dp))
        Box ( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .align(Alignment.CenterHorizontally)
            .padding(start = 35.dp, end = 35.dp )
        ) {
            Box(
                modifier = Modifier
                .width(155.5.dp)
                .height(56.dp)
                .background(Color(red = 227, green = 227, blue = 227, alpha = 255), shape = RoundedCornerShape(10.dp))
//                .align(Alignment.CenterVertically)
//                .align(Alignment.CenterStart)
                .padding(start = 10.dp, end = 15.dp)
//                .align(Alignment.Center)
                    .clickable{ showTimePicker = true }
            ) {
                Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Icon( painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        tint = WhatColor,
                        modifier = Modifier
                            .size(24.dp)
//                        .align(Alignment.CenterStart)

                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = whatTime,
                        style = TextStyle(
                            fontSize = 19.sp,
                            color = WhatColor,
                            fontWeight = FontWeight.Medium
                        ), modifier = Modifier
//                        .align(Alignment.CenterEnd)
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
//            Button( onClick = { showTimePicker = true },
            Box (
                modifier = Modifier
                    .width(155.5.dp)
                    .height(56.dp)
                    .background(WhatColor, shape = RoundedCornerShape(10.dp))
                    .align(Alignment.CenterEnd)
                    .padding(start = 10.dp, end = 10.dp)
                    .clickable{ wantTimestate = true }
            ) {
                Row(
                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
                        .align(Alignment.Center)
                ) {
                    Icon(painter = painterResource(id = R.drawable.icon_timer),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
//                            .align(Alignment.CenterStart)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = "Reschedule",
                        style = TextStyle(
                            fontSize = 19.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium ),
                        modifier = Modifier
//                            .align(Alignment.CenterEnd)
                    )
                }
            }
            if (showTimePicker) {
                val context = LocalContext.current
                val calendar = Calendar.getInstance()

                TimePickerDialog(
                    context,
                    { _, hourOfDay, minute ->
                        val time = LocalTime.of(hourOfDay, minute)
                        showTimePicker = false
                        whatTime = time.format(DateTimeFormatter.ofPattern("HH:mm"))
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    false
                ).show()
            }
            if ( whatTime != "Add Time" && dataPickerState != null && timepickerState != null ) {
                val dateTime = whatTime
                whatTime = "Add Time"
                val millis = dataPickerState
//                onReschedule()

            }

        }
    }
}
//            (
//    onDateSelected: (Long?) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val state = rememberDatePickerState()
//
//    DatePickerDialog(
//        onDismissRequest = onDismiss,
//        confirmButton = {
//            TextButton(
//                onClick = {
//                    onDateSelected(state.selectedDateMillis)
//                    onDismiss()
//                }
//            ) {
//                Text("OK")
//            }
//        },
//            dismissButton = {
//                TextButton(onClick = onDismiss) {
//                    Text("Cancel")
//                }
//            }
//    ) {
//        DatePicker(state = state)
//    }
//}

//fun String.toColor(): Color {
//    return Color(AndroidColor.parseColor(this))
//}

val WhatColor = OpenColor
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateTask(navController: NavHostController, taskViewModel: TaskViewModel = viewModel()) {
    BackHandler(enabled = true) {}
//    val WhatColor = ColorEnum.Main.color.toColor()


    //ver1s
//    val today = remember {
//        val Date = SimpleDateFormat("E dd MMM yyyy", Locale.ENGLISH)
//        Date.format(Date())
//    }
    //ver2
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val focus1 = remember { FocusRequester() }
    val focus2 = remember { FocusRequester() }

    val Date = DateTimeFormatter.ofPattern("E dd MMM yyyy", Locale.ENGLISH)
    val today = remember {
        LocalDate.now().format(Date)
    }
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    var datecolorState by remember { mutableStateOf(Color.LightGray) }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }

    var selectedDatetime = taskViewModel.newSelectedDateMillis

//    val dateSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                BasicTextField(
                    value = text1,
                    onValueChange = { text1 = it },
                    textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                    modifier = Modifier
//                        .fillMaxSize()
                        .height(20.dp)
                        .padding(start = 24.dp)
                        .focusRequester(focus1),
//                        .onKeyEvent{ keyEvent->
//                            if (keyEvent.type == KeyEventType.KeyUp && keyEvent.key == Key.Enter) {
//                                focus2.requestFocus()
//                                true
//                            } else {
//                                false
//                            }
//                        },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focus2.requestFocus()
                        }
                    ),
                    singleLine = true,
                    decorationBox = { innerTextFidel ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
//                                .height(20.dp)
                        ) {
                            if (text1.isEmpty()) {
                                Text(
                                    text = "eg : Meeting with client",
                                    style = TextStyle(
                                        color = Color.LightGray,
                                        fontSize = 16.sp
                                    )
                                )
                            }
                            innerTextFidel()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                BasicTextField(
                    value = text2,
                    onValueChange = { text2 = it },
                    textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                    modifier = Modifier
//                        .fillMaxSize()
                        .height(20.dp)
                        .padding(start = 24.dp)

                        .focusRequester(focus2),
//                        .onKeyEvent{ keyEvent->
//                            if (keyEvent.type == KeyEventType.KeyUp && keyEvent.key == Key.Enter) {
//                                focusManager.clearFocus()
//                                true
//                            } else {
//                                false
//                            }
//                        },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    singleLine = true,
                    decorationBox = { innerTextFidel ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            if (text2.isEmpty()) {
                                Text(
                                    text = "Description",
                                    style = TextStyle(
                                        color = Color.LightGray,
                                        fontSize = 16.sp
                                    )
                                )
                            }
                            innerTextFidel()
                        }
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Box( modifier = Modifier
                    .fillMaxWidth()
//                        .align(Alignment.CenterVertically)
                ) {
                    Row ( modifier = Modifier
                        .align(Alignment.CenterStart)
                    ){
                        Spacer(modifier = Modifier.width(24.dp))
                        Icon(painter = painterResource(id = R.drawable.icon_folder),
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(painter = painterResource(id = R.drawable.icon_calendar),
                            contentDescription = null,
                            tint = datecolorState,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(painter = painterResource(id = R.drawable.icon_clock),
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(painter = painterResource(id = R.drawable.icon_flag),
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.CenterVertically)
                        )
//                        Spacer(modifier = Modifier.width(175.dp))
//                        Icon(painter = painterResource(id = R.drawable.icon_plane),
//                            contentDescription = null,
//                            tint = WhatColor,
//                            modifier = Modifier
//                                .size(20.dp)
////                                .align(Alignment.CenterEnd)
//                        )
//                        Spacer(modifier = Modifier.width(24.dp))
                    }
                    Row ( modifier = Modifier
                        .align(Alignment.CenterEnd)
                    ){  IconButton(onClick = {showDatePicker = true},
                        modifier = Modifier .size(24.dp)) {
                        Icon(painter = painterResource(id = R.drawable.icon_plane),
                            contentDescription = null,
                            tint = WhatColor,
                            modifier = Modifier
                                .size(20.dp)
//                                .align(Alignment.CenterEnd)
                                .align(Alignment.CenterVertically)
                        )
                        if (showDatePicker) {
                            DatePickerModal(
                                onDateSelected = { selectedDate = it },
                                onDismiss = { showDatePicker = false }
                            )
                        }
                    }
                        Spacer(modifier = Modifier.width(24.dp) )
                    }
//                    Icon(painter = painterResource(id = R.drawable.icon_plane),
//                        contentDescription = null,
//                        tint = WhatColor,
//                        modifier = Modifier
//                            .size(20.dp)
//                                .align(Alignment.CenterEnd)
//                    )
//                    Spacer(modifier = Modifier.width(24.dp).align(Alignment.CenterEnd))
//                    Spacer(modifier = Modifier.width(16.dp).align(Alignment.CenterEnd))
                }
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
//                taskList.add(
//                    Taskinfo(
//                        title = ""
//                    )
//                )

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


@Composable
fun DatePickerModal() {
    TODO("Not yet implemented")
}
