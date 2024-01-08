package com.example.rentalmobil.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.rentalmobil.data.MobilRepository
import com.example.rentalmobil.ui.AddEvent
import com.example.rentalmobil.ui.AddUIState
import com.example.rentalmobil.ui.toMobil

class AddViewModel(private val mobilRepository: MobilRepository) : ViewModel() {

    var addUIState by mutableStateOf(AddUIState())
        private set

    fun updateAddUIState(addEvent: AddEvent) {
        addUIState = AddUIState(addEvent = addEvent)
    }

    suspend fun addMobil() {
        mobilRepository.save(addUIState.addEvent.toMobil())
    }
}