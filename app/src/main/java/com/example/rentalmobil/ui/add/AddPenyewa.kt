package com.example.rentalmobil.ui.add

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.AddEventPenyewa

object DestinasiEntryPenyewa : DestinasiNavigasi {
    override val route = "item_entry_penyewa"
    override val titleRes = "Entry Penyewa"
}

@Composable
fun FormInputPenyewa(
    addEventPenyewa: AddEventPenyewa,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventPenyewa) -> Unit = {},
    enabled: Boolean = true
) {}
