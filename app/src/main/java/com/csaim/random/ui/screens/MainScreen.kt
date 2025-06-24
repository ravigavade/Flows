package com.csaim.random.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.csaim.random.viewModel.EventViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MainScreen(viewModel: EventViewModel = viewModel()) {

    val context = LocalContext.current

    //collect sharedFlow
    LaunchedEffect(Unit){
        viewModel.eventFLow.collectLatest { event ->
            when(event){
                is EventViewModel.UiEvent.Message -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    //ui
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                viewModel.onButtonClicked()
            }
        ) {
            Text("Click me")
        }
    }

}