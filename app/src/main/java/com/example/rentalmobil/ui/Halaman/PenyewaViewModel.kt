package com.example.rentalmobil.ui.Halaman

import com.example.rentalmobil.model.Penyewa

sealed class PenyewaUIState {
    data class Success(val penyewa: Penyewa) : PenyewaUIState()
    object Error : PenyewaUIState()
    object Loading : PenyewaUIState()
}