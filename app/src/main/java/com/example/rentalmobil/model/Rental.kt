package com.example.rentalmobil.model

enum class StatusMobil {
    TERSEDIA,
    DISEWA,
    DALAM_PERBAIKAN
}
data class Mobil(
    val id: String = "",
    val merk: String = "" ,
    val model: String = "",
    val tahunProduksi: String = "",
    val warna: String = "",
    val platNomor: String = "",
    val status: String = ""
){
    constructor(): this("","","","","","","")
}

data class Penyewa(
    val id: String,
    val nama: String,
    val alamat: String,
    val noktp: String,
    val nomorTelepon: String,
    val merkmobil: String,
    val tanggalpinjam: String,
    val tanggalkembali: String
){
    constructor(): this ("","","","","","","","")
}