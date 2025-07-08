package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.screen.SplashScreen
import com.example.todolist.ui.screen.ChooseTheme
import com.example.todolist.ui.screen.CreateTask

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            NavigationController()
            val navController = rememberNavController()
            MyAppNavHost(navController)
//            ChooseTheme()
        }
    }
}

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("Theme") {
            ChooseTheme(navController)
        }
        composable("CreateTask") {
            CreateTask(navController)
        }
    }
}


//@Composable
//fun NavigationController() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "splash") {
//        composable("splash") {
//            SplashScreen(navController)
//        }
//        composable("home") {
//            ChooseTheme()
//        }
//    }
//}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TodolistTheme {
//        Greeting("Android")
//    }
//}