package com.example.praktikum4

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.selects.select

@Preview(showBackground = true)
@Composable
fun LatihanUserInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var dataNama by remember { mutableStateOf("") }
    var dataEmail by remember { mutableStateOf("") }
    var dataNohp by remember { mutableStateOf("") }
    var dataAlamat by remember { mutableStateOf("") }

    var jenisK by remember { mutableStateOf("") }
    var dataJenisK by remember { mutableStateOf("") }
    val dataJK = listOf("Laki - laki","Perempuan")
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(20.dp))

        TextField(
            value = nama,
            onValueChange =  {nama = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )
        Row (modifier = Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            dataJK.forEach{selectedJK ->
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(5.dp))
                {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                        jenisK = selectedJK
                    })
                Text(selectedJK)
            }}
        }
        TextField(
            value = email,
            onValueChange =  {email = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            }
        )
        TextField(
            value = nohp,
            onValueChange =  {nohp = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("NoHp")
            },
            placeholder = {
                Text("Masukkan NoHP Anda")
            }
        )
        TextField(
            value = alamat,
            onValueChange =  {alamat = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )
        Button(onClick ={
            dataNama = nama
            dataEmail = email
            dataNohp = nohp
            dataAlamat = alamat

        },modifier = Modifier.padding(vertical = 10.dp) ) {
            Text("Simpan")
        }
        Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column {
                TampilData(
                    judul = "Nama",
                    Isinya = dataNama
                )
                TampilData(
                    judul = "Email",
                    Isinya = dataEmail
                )
                TampilData(
                    judul = "NoHp",
                    Isinya = dataNohp
                )
                TampilData(
                    judul = "Alamat",
                    Isinya = dataAlamat
                )
            }
        }
    }

}
@Composable
fun TampilData(
    judul : String,
    Isinya : String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(" : ", modifier = Modifier.weight(0.8f))
        Text(Isinya, modifier = Modifier.weight(2f))
    }
}