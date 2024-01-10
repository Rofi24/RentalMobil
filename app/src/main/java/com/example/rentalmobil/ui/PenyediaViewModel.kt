package com.example.rentalmobil.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rentalmobil.ui.Halaman.HomeViewModel
import com.example.rentalmobil.RentalAplication
import com.example.rentalmobil.ui.Halaman.PenyewaViewModel
import com.example.rentalmobil.ui.add.AddPenyewaViewModel
import com.example.rentalmobil.ui.add.AddViewModel
import com.example.rentalmobil.ui.detail.DetailPenyewaViewModel
import com.example.rentalmobil.ui.detail.DetailViewModel
import com.example.rentalmobil.ui.edit.EditPenyewaViewModel
import com.example.rentalmobil.ui.edit.EditViewModel

fun CreationExtras.aplikasiRental(): RentalAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RentalAplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            AddViewModel(aplikasiRental().container.mobilRepository)
        }

        initializer {
            HomeViewModel(aplikasiRental().container.mobilRepository)
        }

        initializer {
            DetailViewModel(
                createSavedStateHandle(), aplikasiRental().container.mobilRepository
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiRental().container.mobilRepository
            )
        }
        initializer {
            PenyewaViewModel(aplikasiRental().container.penyewaRepository)
        }
        initializer {
            AddPenyewaViewModel(aplikasiRental().container.penyewaRepository)
        }
        initializer {
            DetailPenyewaViewModel(
                createSavedStateHandle(), aplikasiRental().container.penyewaRepository
            )
        }
        initializer {
            EditPenyewaViewModel(
                createSavedStateHandle(),
                aplikasiRental().container.penyewaRepository
            )
        }
    }
}