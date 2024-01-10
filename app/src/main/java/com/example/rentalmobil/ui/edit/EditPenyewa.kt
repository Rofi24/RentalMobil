package com.example.rentalmobil.ui.edit

import com.example.rentalmobil.navigation.DestinasiNavigasi

object EditPenyewaDestination : DestinasiNavigasi {
    override val route = "item_edit_penyewa"
    override val titleRes ="Edit Penyewa"
    const val penyewaId = "itemId_Penyewa"
    val routeWithArgs = "${EditPenyewaDestination.route}/{$penyewaId}"
}