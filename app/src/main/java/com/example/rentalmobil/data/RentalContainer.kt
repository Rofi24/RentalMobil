package com.example.rentalmobil.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val mobilRepository: MobilRepository
    val penyewaRepository: PenyewaRepository
}

class RentalContainer : AppContainer{
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val mobilRepository: MobilRepository by lazy {
        MobilRepositoryImpl(firestore)
    }
    override val penyewaRepository: PenyewaRepository by lazy {
        PenyewaRepositoryImpl(firestore)
    }
}