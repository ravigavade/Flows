package com.csaim.random.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class EventViewModel: ViewModel() {


    //Event types
    sealed class UiEvent{
        data class Message(val message: String): UiEvent()
    }

    //sharedFlow to emit one-time events
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFLow = _eventFlow.asSharedFlow()

    fun onButtonClicked(){
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.Message("this is a toast message"))
        }
    }

}