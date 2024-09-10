package com.example.learinginapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun NumberOTP() {
    var otpText by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "OTP",
            modifier = Modifier.padding(start = 40.dp, top = 100.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "A 4 digit number has been sent ",
            modifier = Modifier.padding(start = 40.dp, top = 140.dp),
            fontSize = 25.sp,
        )
        BasicTextField(
            value = otpText,
            onValueChange = { otpText = it },
            modifier = Modifier.padding(top =250.dp, end = 30.dp, start = 30.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(4) { index ->
                    val number = when {
                        index >= otpText.length -> ""
                        else -> otpText[index]
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = number.toString(),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Box(
                            modifier = Modifier
                                .width(60.dp)
                                .height(2.dp)
                                .background(Color.Black)

                        )
                    }

                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* TODO: Handle Verify Click */ },
            modifier = Modifier.padding(top = 350.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF060C30),
                contentColor = Color.White
            )
        ) {
            Text(text = "VERIFY")
        }
        Row(
            modifier = Modifier
                .padding(top = 700.dp)
                .align(Alignment.TopCenter)

        ) {
            Text(text = "New to Robo Guru?", modifier = Modifier.padding(top = 14.dp))
            Button(
                onClick = { }, modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Text(text = "RESEND", modifier = Modifier, color = Color.Blue)
            }
        }
    }

}