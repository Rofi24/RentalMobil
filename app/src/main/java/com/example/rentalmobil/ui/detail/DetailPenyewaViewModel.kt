package com.example.rentalmobil.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.PenyewaRepository
import com.example.rentalmobil.ui.DetailUIStatePenyewa
import com.example.rentalmobil.ui.toDetailPenyewa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailPenyewaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: PenyewaRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val penyewaId: String = checkNotNull(savedStateHandle[DetailDestinationPenyewa.penyewaId])

    val uiState: StateFlow<DetailUIStatePenyewa> =
        repository.getPenyewaById(penyewaId)
            .filterNotNull()
            .map {
                DetailUIStatePenyewa(addEventPenyewa = it.toDetailPenyewa())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStatePenyewa()
            )
    suspend fun deletePenyewa() {
        repository.delete(penyewaId)
    }
}