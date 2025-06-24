package com.csaim.random.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.csaim.random.data.model.UiEvent
import com.csaim.random.viewModel.EventViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(navController: NavController,viewModel: EventViewModel = viewModel()) {

    val context = LocalContext.current

    //collect sharedFlow
    LaunchedEffect(Unit){
        viewModel.eventFLow.collectLatest { event ->
            when(event){
                is UiEvent.Message -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
                }
                is UiEvent.Navigation -> {
                    navController.navigate(event.route)
                }

            }
        }
    }

    //ui
    Column (
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.onButtonClicked()
            }
        ) {
            Text("Click me")
        }

        Button(
            onClick = {
                viewModel.onNavigation()
            }
        ) {
            Text("next")
        }
    }

}