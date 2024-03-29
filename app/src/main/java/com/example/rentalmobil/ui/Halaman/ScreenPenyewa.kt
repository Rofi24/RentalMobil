package com.example.rentalmobil.ui.Halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rentalmobil.R
import com.example.rentalmobil.model.Penyewa
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.PenyediaViewModel
import com.example.rentalmobil.ui.RentalTopAppBar

object DestinasiScreen : DestinasiNavigasi {
    override val route = "screen"
    override val titleRes = "Penyewa"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPenyewa(
    navigateToItemEntryPenyewa: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: PenyewaViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            RentalTopAppBar(
                title = "Data Penyewa",
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                FloatingActionButton(
                    onClick = navigateToItemEntryPenyewa,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        val uiStatePenyewa by viewModel.penyewaUIState.collectAsState()
        BodyHome(
            itemPenyewa = uiStatePenyewa.listPenyewa,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onPenyewaClick = onDetailClick,

        )
    }
}

@Composable
fun BodyHome(
    itemPenyewa: List<Penyewa>,
    modifier: Modifier = Modifier,
    onPenyewaClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPenyewa.isEmpty()) {
            Text(
                text = "Tidak ada data Penyewa",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListPenyewa(
                    itemPenyewa = itemPenyewa,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) { onPenyewaClick(it.id)
            }
        }
    }
}

@Composable
fun ListPenyewa(
    itemPenyewa: List<Penyewa>,
    modifier: Modifier = Modifier,
    onItemClick: (Penyewa) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemPenyewa, key = { it.id }) { penyewa ->
            DataPenyewa(
                penyewa = penyewa,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(penyewa) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataPenyewa(
    penyewa: Penyewa,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = penyewa.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = penyewa.nomorTelepon,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}