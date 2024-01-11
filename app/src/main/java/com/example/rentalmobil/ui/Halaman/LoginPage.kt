package com.example.rentalmobil.ui.Halaman

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rentalmobil.R
import com.example.rentalmobil.navigation.DestinasiNavigasi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object DestinasiLogin : DestinasiNavigasi {
    override val route = "login"
    override val titleRes = "login_page"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavController
) {
    val context = LocalContext.current
    lateinit var auth: FirebaseAuth
    auth = Firebase.auth
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to JogjaRentCar!",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Please login to your account.",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(value = emailText,
                onValueChange = { emailText = it },
                label = { Text(text = "Email")},
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "Email Icon",
                        )
                    }
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(vertical = 5.dp)
            )
            OutlinedTextField(value = passwordText,
                onValueChange = {passwordText = it},
                label = { Text(text = "Password")},
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "Pass Icon")
                    }
                },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding( vertical = 5.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { (
                        auth.signInWithEmailAndPassword(emailText, passwordText)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    navController.navigate(DestinasiHome.route)
                                    Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, "Harap masukkan email atau password dengan benar", Toast.LENGTH_SHORT).show()
                                }
                            }
                        ) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.DarkGray
                )
            )
            {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(16.dp))}
    }
}
