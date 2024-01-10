package com.example.rentalmobil.ui.edit

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.PenyediaViewModel

object EditPenyewaDestination : DestinasiNavigasi {
    override val route = "item_edit_penyewa"
    override val titleRes ="Edit Penyewa"
    const val penyewaId = "itemId_Penyewa"
    val routeWithArgs = "${EditPenyewaDestination.route}/{$penyewaId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPenyewa(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditPenyewaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {}