// src/main/java/com/example/todolist/ui/theme/TaskViewModel.kt
package com.example.todolist.ui.theme

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf // mutableStateListOf import 추가
import com.example.todolist.ui.screen.Taskinfo // Taskinfo의 정확한 패키지 경로를 확인하여 수정
import java.time.LocalTime
import java.time.ZoneId // ZoneId import 추가

class TaskViewModel : ViewModel() {

    var newTaskTitle by mutableStateOf("")
        private set

    var newTaskDescription by mutableStateOf("")
        private set

    var newSelectedDateMillis by mutableStateOf<Long?>(null) //날짜
        private set

    var newSelectedTime by mutableStateOf<LocalTime?>(null) //시간
        private set


    private val _taskList = mutableStateListOf<Taskinfo>()
    val taskList: List<Taskinfo> = _taskList

    fun updateNewTaskTitle(title: String) {
        newTaskTitle = title
    }

    fun updateNewTaskDescription(description: String) {
        newTaskDescription = description
    }

    fun updateNewSelectedDateMillis(millis: Long?) {
        newSelectedDateMillis = millis
    }

    fun updateNewSelectedTime(time: LocalTime?) {
        newSelectedTime = time
    }

    fun addTask() {
        if (newTaskTitle.isBlank()) {
            return
        }

        val fullDateTimeMillis = newSelectedDateMillis?.let { dateMillis ->
            newSelectedTime?.let { time ->
                val localDate = java.time.Instant.ofEpochMilli(dateMillis).atZone(ZoneId.systemDefault()).toLocalDate()
                val localDateTime = java.time.LocalDateTime.of(localDate, time)
                localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
            } ?: dateMillis
        }

        val newTask = Taskinfo(
            title = newTaskTitle,
            description = newTaskDescription,
            dueTime = fullDateTimeMillis,
            dueMillis = newSelectedDateMillis,
            done = false
        )
        _taskList.add(newTask)

        resetNewTaskFields()
    }

    private fun resetNewTaskFields() {
        newTaskTitle = ""
        newTaskDescription = ""
        newSelectedDateMillis = null
        newSelectedTime = null
    }
}