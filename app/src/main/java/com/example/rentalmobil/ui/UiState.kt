package com.example.rentalmobil.ui

import com.example.rentalmobil.model.Mobil

data class AddUIState(
    val addEvent: AddEvent = AddEvent()
)

data class AddEvent(
    val id: String = "",
    val merk: String = "",
    val model: String = "",
    val tahunProduksi: String = "",
    val warna: String = "",
    val platNomor: String = "",
    val status: String = ""
)

fun AddEvent.toMobil() = Mobil(
    id = id,
    merk = merk,
    model = model,
    tahunProduksi = tahunProduksi,
    warna = warna,
    platNomor = platNomor,
    status = status
)

data class DetailUIState(
    val addEvent: AddEvent = AddEvent()
)

fun Mobil.toDetailMobil(): AddEvent =
    AddEvent(
        id = id,
        merk = merk,
        model = model,
        tahunProduksi = tahunProduksi,
        warna = warna,
        platNomor = platNomor,
        status = status
    )

fun Mobil.toUIStateMobil(): AddUIState = AddUIState(
    addEvent = this.toDetailMobil()
)

data class HomeUIState(
    val listMobil: List<Mobil> = listOf(),
    val dataLength: Int = 0
)