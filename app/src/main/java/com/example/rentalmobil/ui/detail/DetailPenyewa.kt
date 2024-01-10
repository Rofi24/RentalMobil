package com.example.rentalmobil.ui.detail

import com.example.rentalmobil.navigation.DestinasiNavigasi

object DetailDestinationPenyewa : DestinasiNavigasi {
    override val route = "item_details_penyewa"
    override val titleRes = "Detail Penyewa"
    const val penyewaId = "itemId_penyewa"
    val routeWithArgs = "$route/{$penyewaId}"
}