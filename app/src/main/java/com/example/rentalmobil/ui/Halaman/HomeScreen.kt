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
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.rentalmobil.model.Mobil
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.PenyediaViewModel
import com.example.rentalmobil.ui.RentalTopAppBar

object DestinasiHome : DestinasiNavigasi{
    override val route = "home"
    override val titleRes = "Data Mobil"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToScreenPenyewa: () -> Unit,
    navigateToItemEntryMobil: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            RentalTopAppBar(
                title = "Data Mobil",
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                FloatingActionButton(
                    onClick = navigateToScreenPenyewa,
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))

                FloatingActionButton(
                    onClick = navigateToItemEntryMobil,
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
            }
        },
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        val uiStateRental by viewModel.homeUIState.collectAsState()
        BodyHome(
            itemMobil = uiStateRental.listMobil,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onMobilClick = onDetailClick
        )
    }
}

@Composable
fun BodyHome(
    itemMobil: List<Mobil>,
    modifier: Modifier = Modifier,
    onMobilClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemMobil.isEmpty()) {
            Text(
                text = "Tidak ada data Mobil",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListMobil(
                itemMobil = itemMobil,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onMobilClick(it.id) }
            )
        }
    }
}

@Composable
fun ListMobil(
    itemMobil: List<Mobil>,
    modifier: Modifier = Modifier,
    onItemClick: (Mobil) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemMobil, key = { it.id }) { mobil ->
            DataMobil(
                mobil = mobil,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(mobil) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataMobil(
    mobil: Mobil,
    modifier: Modifier = Modifier,
    onDeleteClick: (String) -> Unit = {}
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
                    text = mobil.merk,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))

                Text(text = mobil.platNomor,
                    style = MaterialTheme.typography.titleMedium,
                    )
            }
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = mobil.status,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(Modifier.weight(1f))

                Text(text = mobil.warna,
                    style = MaterialTheme.typography.titleMedium
                    )
            }
        }
    }
}






