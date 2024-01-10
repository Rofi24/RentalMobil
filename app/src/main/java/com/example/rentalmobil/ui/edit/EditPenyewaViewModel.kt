package com.example.rentalmobil.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rentalmobil.data.PenyewaRepository
import com.example.rentalmobil.ui.AddPenyewaUIState


class EditPenyewaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: PenyewaRepository
) : ViewModel() {
    var penyewaUiState by mutableStateOf(AddPenyewaUIState())
        private set
}