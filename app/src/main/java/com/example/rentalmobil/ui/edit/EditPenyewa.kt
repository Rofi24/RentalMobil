package com.example.rentalmobil.ui.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rentalmobil.R
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.PenyediaViewModel
import com.example.rentalmobil.ui.RentalTopAppBar
import com.example.rentalmobil.ui.add.EntryBodyPenyewa
import kotlinx.coroutines.launch

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
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            RentalTopAppBar(
                title =EditPenyewaDestination.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        EntryBodyPenyewa(
            addPenyewaUIState = viewModel.penyewaUiState,
            onPenyewaValueChange = viewModel::updateUIStatePenyewa,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updatePenyewa()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}