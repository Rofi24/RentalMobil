package com.example.rentalmobil.ui

import com.example.rentalmobil.model.Mobil
import com.example.rentalmobil.model.Penyewa

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



//Penyewa
data class AddPenyewaUIState(
    val addEventPenyewa: AddEventPenyewa = AddEventPenyewa()
)

data class AddEventPenyewa(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val nomorTelepon: String = "",
    val email: String = ""
)

fun AddEventPenyewa.toPenyewa() = Penyewa(
    id = id ,
    nama = nama,
    alamat = alamat,
    nomorTelepon = nomorTelepon,
    email = email
)

data class DetailUIStatePenyewa(
    val addEventPenyewa: AddEventPenyewa = AddEventPenyewa()
)

fun Penyewa.toDetailPenyewa(): AddEventPenyewa =
    AddEventPenyewa(
        id = id ,
        nama = nama,
        alamat = alamat,
        nomorTelepon = nomorTelepon,
        email = email
    )

fun Penyewa.toUIStatePenyewa(): AddPenyewaUIState = AddPenyewaUIState(
    addEventPenyewa = this.toDetailPenyewa()
)

data class ScreenUIState(
    val listPenyewa: List<Penyewa> = listOf(),
    val dataLength: Int = 0
)
