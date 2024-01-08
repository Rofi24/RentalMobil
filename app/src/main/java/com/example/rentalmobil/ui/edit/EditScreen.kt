package com.example.rentalmobil.ui.edit

import com.example.rentalmobil.navigation.DestinasiNavigasi

object EditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes ="Edit Kontak"
    const val mobilId = "itemId"
    val routeWithArgs = "${EditDestination.route}/{$mobilId}"
}