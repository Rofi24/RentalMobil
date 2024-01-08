package com.example.rentalmobil.ui.detail

import com.example.rentalmobil.navigation.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "Detail Mobil"
    const val mobilId = "itemId"
    val routeWithArgs = "$route/{$mobilId}"
}