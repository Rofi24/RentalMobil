package com.example.rentalmobil.ui.Halaman

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.MobilRepository
import com.example.rentalmobil.model.Mobil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

sealed class RentalUIState {
    data class Success(val kontak: Flow<List<Mobil>>) : RentalUIState()
    object Error : RentalUIState()
    object Loading : RentalUIState()

}


