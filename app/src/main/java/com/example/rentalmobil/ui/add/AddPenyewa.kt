package com.example.rentalmobil.ui.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rentalmobil.R
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.AddEventPenyewa
import com.example.rentalmobil.ui.AddPenyewaUIState
import com.example.rentalmobil.ui.PenyediaViewModel
import com.example.rentalmobil.ui.RentalTopAppBar
import kotlinx.coroutines.launch

object DestinasiEntryPenyewa : DestinasiNavigasi {
    override val route = "item_entry_penyewa"
    override val titleRes = "Entry Penyewa"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPenyewa(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addPenyewaViewModel: AddPenyewaViewModel = viewModel(factory = PenyediaViewModel.Factory )
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            RentalTopAppBar(
                title = DestinasiEntryPenyewa.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        EntryBodyPenyewa(
            addPenyewaUIState = addPenyewaViewModel.addPenyewaUIState,
            onPenyewaValueChange = addPenyewaViewModel::updateAddPenyewaUIState,
            onSaveClick = {
                coroutineScope.launch {
                    addPenyewaViewModel.addPenyewa()
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
@Composable
fun EntryBodyPenyewa(
    addPenyewaUIState: AddPenyewaUIState,
    onPenyewaValueChange: (AddEventPenyewa) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInputPenyewa(
            addEventPenyewa = addPenyewaUIState.addEventPenyewa,
            onValueChange = onPenyewaValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputPenyewa(
    addEventPenyewa: AddEventPenyewa,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventPenyewa) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = addEventPenyewa.nama,
            onValueChange = { onValueChange(addEventPenyewa.copy(nama = it)) },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
        OutlinedTextField(
            value = addEventPenyewa.alamat,
            onValueChange = { onValueChange(addEventPenyewa.copy(alamat = it)) },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
        OutlinedTextField(
            value = addEventPenyewa.noktp,
            onValueChange = { onValueChange(addEventPenyewa.copy(noktp = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "No KTP") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
        OutlinedTextField(
            value = addEventPenyewa.nomorTelepon,
            onValueChange = { onValueChange(addEventPenyewa.copy(nomorTelepon = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Nomor Telepon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
        OutlinedTextField(
            value = addEventPenyewa.merkmobil,
            onValueChange = { onValueChange(addEventPenyewa.copy(merkmobil = it)) },
            label = { Text("Merk Mobil") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
        OutlinedTextField(
            value = addEventPenyewa.tanggalpinjam,
            onValueChange = { onValueChange(addEventPenyewa.copy(tanggalpinjam = it)) },
            label = { Text("Tanggal Pinjam") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
        OutlinedTextField(
            value = addEventPenyewa.tanggalkembali,
            onValueChange = { onValueChange(addEventPenyewa.copy(tanggalkembali = it)) },
            label = { Text("Tanggal Kembali") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}
