package com.example.rentalmobil.ui.Halaman

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.MobilRepository
import com.example.rentalmobil.model.Mobil
import com.example.rentalmobil.ui.HomeUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class RentalUIState {
    data class Success(val mobil: Flow<List<Mobil>>) : RentalUIState()
    object Error : RentalUIState()
    object Loading : RentalUIState()

}

class HomeViewModel(private val rentalRepository: MobilRepository) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUIState: StateFlow<HomeUIState> = rentalRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIState (listMobil = it.toList(), it.size ) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIState()

        )

}


