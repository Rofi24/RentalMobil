package com.example.rentalmobil.ui.detail

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rentalmobil.navigation.DestinasiNavigasi

object DetailDestinationPenyewa : DestinasiNavigasi {
    override val route = "item_details_penyewa"
    override val titleRes = "Detail Penyewa"
    const val penyewaId = "itemId_penyewa"
    val routeWithArgs = "$route/{$penyewaId}"
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier = Modifier
) {
    AlertDialog(onDismissRequest = { /* Do nothing */ },
        title = { Text("Apakah anda yakin ingin menghapus data penyewa ini dari list?") },
        text = { Text("Hapus") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "Tidak")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Ya")
            }
        }
    )
}