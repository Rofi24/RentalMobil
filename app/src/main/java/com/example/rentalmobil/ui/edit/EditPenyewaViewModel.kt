package com.example.rentalmobil.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.PenyewaRepository
import com.example.rentalmobil.ui.AddEventPenyewa
import com.example.rentalmobil.ui.AddPenyewaUIState
import com.example.rentalmobil.ui.toUIStatePenyewa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class EditPenyewaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: PenyewaRepository
) : ViewModel() {
    var penyewaUiState by mutableStateOf(AddPenyewaUIState())
        private set

    private val penyewaId: String = checkNotNull(savedStateHandle[EditPenyewaDestination.penyewaId])

    init {
        viewModelScope.launch {
            penyewaUiState =
                repository.getPenyewaById(penyewaId)
                    .filterNotNull()
                    .first()
                    .toUIStatePenyewa()
        }
    }
    fun updateUIStatePenyewa(addEventPenyewa: AddEventPenyewa) {
        penyewaUiState = penyewaUiState.copy(addEventPenyewa = addEventPenyewa)
    }
}