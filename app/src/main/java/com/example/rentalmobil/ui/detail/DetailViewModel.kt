package com.example.rentalmobil.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentalmobil.data.MobilRepository
import com.example.rentalmobil.ui.DetailUIState
import com.example.rentalmobil.ui.toDetailMobil
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: MobilRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val mobilId: String = checkNotNull(savedStateHandle[DetailDestination.mobilId])

    val uiState: StateFlow<DetailUIState> =
        repository.getMobilById(mobilId)
            .filterNotNull()
            .map {
                DetailUIState(addEvent = it.toDetailMobil())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIState()
            )

    suspend fun deleteMobil() {
        repository.delete(mobilId)

    }
}

