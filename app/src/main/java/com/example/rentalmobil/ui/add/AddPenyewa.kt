package com.example.rentalmobil.ui.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.example.rentalmobil.ui.AddEventPenyewa
import com.example.rentalmobil.ui.AddPenyewaUIState

object DestinasiEntryPenyewa : DestinasiNavigasi {
    override val route = "item_entry_penyewa"
    override val titleRes = "Entry Penyewa"
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
            singleLine = true
        )
        OutlinedTextField(
            value = addEventPenyewa.alamat,
            onValueChange = { onValueChange(addEventPenyewa.copy(alamat = it)) },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventPenyewa.nomorTelepon,
            onValueChange = { onValueChange(addEventPenyewa.copy(nomorTelepon = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Nomor Telepon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEventPenyewa.email,
            onValueChange = { onValueChange(addEventPenyewa.copy(email = it)) },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}
