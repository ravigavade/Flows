package com.csaim.random

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class EventViewModel:ViewModel() {


    private val _eventFlow = MutableStateFlow<UiEvent>()





    sealed class UiEvent {

    }


}
