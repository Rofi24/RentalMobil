package com.example.rentalmobil.ui.theme.Halaman

import com.example.rentalmobil.model.Mobil
import kotlinx.coroutines.flow.Flow

sealed class RentalUIState {
    data class Success(val kontak: Flow<List<Mobil>>) : RentalUIState()
    object Error : RentalUIState()
    object Loading : RentalUIState()

}



