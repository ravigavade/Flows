package com.csaim.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class EventViewModel:ViewModel() {


    //shared flow to emit one time events
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    // trigger the event
    fun onButtonClicked(){
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.ShowToast("supp boi"))
        }
    }




    // event types
    sealed class UiEvent {
        data class ShowToast(val mesage : String) : UiEvent()
    }


}
