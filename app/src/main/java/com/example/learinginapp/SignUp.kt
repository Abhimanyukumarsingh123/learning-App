package com.example.learinginapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Visibility
import androidx.navigation.NavController


@Composable
fun SignUp(navController: NavController) {

    var phoneNumber by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var isNewPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }

    val maxLength = 25

    Box(modifier = Modifier.fillMaxSize())

    IconButton(onClick = { navController.navigate("Home_page")}, modifier = Modifier.padding(top = 30.dp, start = 30.dp)) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp)
                .size(30.dp)
        )
    }
    Text(
        text = "Sign Up",
        modifier = Modifier.padding(top = 100.dp, start = 40.dp),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold

    )
    Text(
        text = "Welcome back to your smart Learning Path!",
        modifier = Modifier.padding(top = 150.dp, start = 40.dp, end = 15.dp), fontSize = 27.sp
    )
    TextField(
        value = phoneNumber,
        onValueChange = { phoneNumber = it },
        placeholder = {
            Text(text = "Phone No. / Email ID", modifier = Modifier.padding(start = 20.dp))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email
        ),
        modifier = Modifier
            .padding(top = 260.dp, start = 40.dp, end = 40.dp)
            .fillMaxWidth()
    )

    TextField(
        value = password,
        onValueChange = {
            if (it.all { char -> char.isDefined() } && it.length <= maxLength) {
                password= it
            }
        },
        placeholder = {
            Text(text = "New Password", modifier = Modifier.padding(start = 20.dp))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        visualTransformation = if (isNewPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isNewPasswordVisible = !isNewPasswordVisible }) {
                Icon(
                    imageVector = if (isNewPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (isNewPasswordVisible) "Hide password" else "Show password"
                )
            }
        },
        modifier = Modifier
            .padding(top = 340.dp, start = 40.dp, end = 40.dp)
            .fillMaxWidth(),
    )
    TextField(
        value = confirmPassword,
        onValueChange = {
            if (it.all { char -> char.isDefined() } && it.length <= maxLength) {
                confirmPassword= it
            }
        },
        placeholder = {
            Text(text = "Conform Password", modifier = Modifier.padding(start = 20.dp))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isConfirmPasswordVisible = !isConfirmPasswordVisible }) {
                Icon(
                    imageVector = if (isConfirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (isConfirmPasswordVisible) "Hide password" else "Show password"
                )
            }
        },
        modifier = Modifier
            .padding(top = 420.dp, start = 40.dp, end = 40.dp)
            .fillMaxWidth()
    )
    if (password.isNotEmpty() && confirmPassword.isNotEmpty() && password != confirmPassword) {
        Text(
            text = "Passwords do not match",
            color = Color.Red,
            modifier = Modifier.padding(top = 470.dp, start = 40.dp, end = 40.dp)
        )
    }
    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 500.dp)
            .width(320.dp)
            .height(60.dp)
            .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

    ) {
        Button(
            onClick = { navController.navigate("Verification_Email") }, modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = (Color(0x8BCFCAC1)),
                contentColor = Color.Black,
            )
        ) {
            Text(text = "SIGN UP")
        }
    }

    Text(
        text = "Or continue Sign in with",
        modifier = Modifier.padding(
            top = 600.dp,
            start = 100.dp
        ), fontSize = 18.sp
    )
    Row(modifier = Modifier.padding(top = 650.dp)) {
        Box(
            modifier = Modifier
                .padding(start = 40.dp)
                .width(130.dp)
                .height(60.dp)
                .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(70.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gooo),
                    contentDescription = null

                )

            }

        }
        Box(
            modifier = Modifier
                .padding(start = 50.dp)
                .width(130.dp)
                .height(60.dp)
                .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(70.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fac),
                    contentDescription = null

                )

            }
        }
    }
    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 730.dp)
            .width(320.dp)
            .height(60.dp)
            .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

    ) {
        Button(
            onClick ={navController.navigate("Sing_In")}, modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            )
        ) {
            Row{
                Text(text = "New to Robo Guru? ")
                Text(text = "SIGN IN", modifier = Modifier, color = Color.Blue)
            }

        }
    }
}