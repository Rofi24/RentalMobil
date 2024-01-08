package com.example.rentalmobil

import android.app.Application
import com.example.rentalmobil.data.AppContainer
import com.example.rentalmobil.data.RentalContainer

class RentalAplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = RentalContainer()
    }
}