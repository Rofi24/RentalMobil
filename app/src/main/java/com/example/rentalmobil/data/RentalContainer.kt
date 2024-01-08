package com.example.rentalmobil.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val rentalRepository: MobilRepository
}

class RentalContainer : AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val rentalRepository: MobilRepository by lazy {
        MobilRepositoryImpl(firestore)
    }
}