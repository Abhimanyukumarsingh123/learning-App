package com.example.learinginapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun verificationEmail(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ) {
            IconButton(onClick = {navController.navigate("Sing_Up") }, modifier = Modifier.padding(top = 20.dp)) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
            Text(
                text = "Verification",
                modifier = Modifier.padding(15.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
            Text(
                text = "We will sent A 4 digit One time password on this email",
                modifier = Modifier.padding(15.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.W400
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp, top = 50.dp, end = 20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                ),
                placeholder = {
                    Text(text = "Enter Emial Id", modifier = Modifier.padding(start = 20.dp))
                }
            )
            Box(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

            ) {
                Button(
                    onClick = {navController.navigate("Email_OTP") }, modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = (Color(0xFC060C30)),
                        contentColor = Color.White,
                    )
                ) {
                    Text(text = "SEND OTP")
                }

            }
            Text(
                text = "Or continye Sigh up with",
                modifier = Modifier.padding(top = 150.dp, start = 80.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                        .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.TopCenter),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gooo),
                            contentDescription = null
                        )

                    }
                }
                Box(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .width(150.dp)
                        .height(60.dp)
                        .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .align(Alignment.TopCenter),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.app),
                            contentDescription = null
                        )

                    }

                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 20.dp, start = 5.dp)
                    .width(320.dp)
                    .height(60.dp)
                    .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

            ) {
                Button(
                    onClick = { navController.navigate("Sing_In")}, modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    )
                ) {
                    Row {
                        Text(text = "New to Robo Guru? ")
                        Text(text = "SIGN IN", modifier = Modifier, color = Color.Blue)
                    }

                }
            }

        }
    }

}



