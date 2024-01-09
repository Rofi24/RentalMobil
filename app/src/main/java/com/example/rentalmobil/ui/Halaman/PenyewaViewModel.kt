package com.example.rentalmobil.ui.Halaman

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.PenyewaRepository
import com.example.rentalmobil.model.Penyewa
import com.example.rentalmobil.ui.ScreenUIState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class PenyewaUIState {
    data class Success(val penyewa: Penyewa) : PenyewaUIState()
    object Error : PenyewaUIState()
    object Loading : PenyewaUIState()

}

class PenyewaViewModel(private val penyewaRepository: PenyewaRepository) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val penyewaUIState: StateFlow<ScreenUIState> = penyewaRepository.getAll()
        .filterNotNull()
        .map {
            ScreenUIState (listPenyewa = it.toList(),it.size) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ScreenUIState()

        )

}