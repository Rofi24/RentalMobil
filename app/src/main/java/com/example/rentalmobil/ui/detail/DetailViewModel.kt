package com.example.rentalmobil.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rentalmobil.data.MobilRepository

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: MobilRepository
) : ViewModel() {}