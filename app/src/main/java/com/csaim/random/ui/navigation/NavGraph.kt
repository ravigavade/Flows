package com.csaim.random.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.csaim.random.ui.screens.MainScreen
import com.csaim.random.ui.screens.Second
import com.csaim.random.viewModel.EventViewModel

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost( navController, startDestination ="home") {

        composable("home"){
            MainScreen(navController)
        }

        composable("Second"){
            Second(navController)
        }

    }
    
}