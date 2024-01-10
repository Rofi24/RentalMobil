package com.example.rentalmobil.ui.edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rentalmobil.data.PenyewaRepository


class EditPenyewaViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: PenyewaRepository
) : ViewModel() {}