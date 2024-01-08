package com.example.rentalmobil.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.MobilRepository
import com.example.rentalmobil.ui.AddEvent
import com.example.rentalmobil.ui.AddUIState
import com.example.rentalmobil.ui.toUIStateMobil
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: MobilRepository
) : ViewModel() {
    var rentalUiState by mutableStateOf(AddUIState())
        private set

    private val mobilId: String = checkNotNull(savedStateHandle[EditDestination.mobilId])

    init {
        viewModelScope.launch {
            rentalUiState =
                repository.getMobilById(mobilId)
                    .filterNotNull()
                    .first()
                    .toUIStateMobil()
        }
    }

    fun updateUIState(addEvent: AddEvent) {
        rentalUiState = rentalUiState.copy(addEvent = addEvent)
    }
}