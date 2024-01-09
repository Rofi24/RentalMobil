package com.example.rentalmobil.ui.Halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.PenyediaViewModel

object DestinasiScreen : DestinasiNavigasi {
    override val route = "screen"
    override val titleRes = "Penyewa"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPenyewa(
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: PenyewaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
}