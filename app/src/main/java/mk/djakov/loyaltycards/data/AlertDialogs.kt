package mk.djakov.loyaltycards.data

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import mk.djakov.loyaltycards.ui.MainViewModel

@Composable
fun InsertCard(viewModel: MainViewModel, showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
    var nameValue by savedInstanceState(saver = TextFieldValue.Saver) { TextFieldValue() }
    var barcodeValue by savedInstanceState(saver = TextFieldValue.Saver) { TextFieldValue() }
    var ownerValue by savedInstanceState(saver = TextFieldValue.Saver) { TextFieldValue() }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text("Insert a new card")
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.insertCard(nameValue.text, barcodeValue.text, ownerValue.text)
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Column(
                    Modifier
                        .padding(8.dp)
                        .clickable(onClick = { })
                        .fillMaxWidth()
                ) {
                    TextField(
                        value = nameValue,
                        onValueChange = { nameValue = it },
                        placeholder = { Text("Label name") })
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
                    ) {
                        IconButton(
                            modifier = Modifier.then(Modifier.preferredSize(48.dp)),
                            onClick = { }) {
                            Icon(
                                Icons.Filled.QrCode,
                                tint = Color.White
                            )
                        }
                        TextField(
                            value = barcodeValue,
                            onValueChange = { barcodeValue = it },
                            modifier = Modifier.padding(end = 10.dp),
                            placeholder = { Text(text = "Barcode") }
                        )

                    }
                    TextField(
                        value = ownerValue,
                        onValueChange = { ownerValue = it },
                        placeholder = { Text(text = "Owner") })
                }
            })
    }
}

//TODO Add input fields validator