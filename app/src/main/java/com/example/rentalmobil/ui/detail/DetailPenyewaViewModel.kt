package com.example.rentalmobil.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rentalmobil.data.PenyewaRepository

class DetailPenyewaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: PenyewaRepository
) : ViewModel() {}