package com.example.rentalmobil.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.rentalmobil.data.PenyewaRepository
import com.example.rentalmobil.ui.AddEventPenyewa
import com.example.rentalmobil.ui.AddPenyewaUIState
import com.example.rentalmobil.ui.toPenyewa

class AddPenyewaViewModel(private val penyewaRepository: PenyewaRepository) : ViewModel() {

    var addPenyewaUIState by mutableStateOf(AddPenyewaUIState())
        private set

    fun updateAddPenyewaUIState(addEventPenyewa: AddEventPenyewa) {
        addPenyewaUIState = AddPenyewaUIState(addEventPenyewa = addEventPenyewa)
    }

    suspend fun addPenyewa() {
        penyewaRepository.save(addPenyewaUIState.addEventPenyewa.toPenyewa())
    }
}