package com.example.ucp1_20220140002

import android.graphics.drawable.ShapeDrawable
import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable
fun ucp1(modifier: Modifier = Modifier){
Column (modifier = Modifier.fillMaxSize()) {
    HeaderSection()
    isidata()
}
}

@Composable
fun HeaderSection(){
    Box(modifier = Modifier.fillMaxWidth().
    background(color = Color.Blue).
    padding(15.dp)){
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column (modifier = Modifier.padding(5.dp)){
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    text = "Halo, ",
                    color = Color.White, fontSize = 30.sp
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "Surya Guntur Suprapto",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Box(
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gambar),
                    contentDescription = "", modifier = Modifier
                        .padding(10.dp)
                        .size(100.dp)
                        .clip(CircleShape)

                )
            }
        }
    }
}

@Composable
fun isidata(){
    var nama by remember { mutableStateOf("") }
    var nohp by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var nohpsv by remember { mutableStateOf("") }
    var memilihJKsv by remember { mutableStateOf("") }

    val listJK:List<String> = listOf("Laki-Laki", "Perempuan")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Row {
            Text(
                "Yuk Lengkapi Data Dirimu !",
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold, fontSize = 20.sp

            )
        }
        Spacer(modifier = Modifier.padding(5.dp))

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nama,
            singleLine = true,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama") },
        )


        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nohp,
            singleLine = true,
            onValueChange = { nohp = it },
            label = { Text("No Handphone") },
            placeholder = { Text("Masukkan No Handphone") },
        )

        Box(modifier = Modifier.padding(10.dp)) {
            Column() {
                Text("Jenis Kelamin", fontSize = 20.sp)
            }
            Row(modifier = Modifier.padding(10.dp)) {
                listJK.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = memilihJK == item,
                        onClick = { memilihJK = item }
                    ), verticalAlignment = Alignment.CenterVertically)
                    {
                        RadioButton(
                            selected = memilihJK == item,
                            onClick = {
                                memilihJK = item
                            }
                        )
                        Text(item, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }
            }
        }

        Button(
            onClick = {
                namasv = nama
                nohpsv = nohp
                memilihJKsv = memilihJK
            }, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) )
        {
            Text("Submit", color = Color.White)
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth().padding(10.dp),
        ) {
            DetailSurat(judul = "No HP", isinya = nohpsv)
            DetailSurat(judul = "Gender", isinya = memilihJKsv)
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(top = 2.dp)) {
            Text(
                text = judul,
                modifier = Modifier.weight(0.8f),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 17.sp
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.8f),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 17.sp
            )
            Text(
                text = isinya,
                modifier = Modifier.weight(2f),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 17.sp
            )
        }
    }
}

