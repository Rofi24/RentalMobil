package com.example.rentalmobil.ui.theme

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rentalmobil.ui.Halaman.HomeViewModel
import com.example.rentalmobil.RentalAplication
import com.example.rentalmobil.ui.add.AddViewModel

fun CreationExtras.aplikasiRental(): RentalAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RentalAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            AddViewModel(aplikasiRental().container.rentalRepository)
        }

        initializer {
            HomeViewModel(aplikasiRental().container.rentalRepository)
        }
    }
}