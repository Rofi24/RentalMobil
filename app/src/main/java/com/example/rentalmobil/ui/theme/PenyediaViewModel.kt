package com.example.rentalmobil.ui.theme

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.rentalmobil.ui.RentalAplication

fun CreationExtras.aplikasiRental(): RentalAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RentalAplication)
