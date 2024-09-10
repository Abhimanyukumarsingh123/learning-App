package com.example.learinginapp


import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.learinginapp.ui.theme.LearinginAppTheme
import io.ktor.websocket.Frame

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okio.IOException

class MainActivity : ComponentActivity() {


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearinginAppTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = "Home_page",
                        builder = {
                            composable("Home_page") {
                                HOmnePage(navController)
                            }
                            composable("Sing_In") {
                                SignIn(navController)
                           }
                            composable("Sing_Up") {
                                SignUp(navController)
                            }
                            composable("Verification_Email") {
                                verificationEmail(navController)
                            }
                            composable("Email_OTP") {
                                EmailOTP(navController)
                            }
                            composable("Student_Details") {
                                StudentDetails(navController)
                            }
                        }
                    )
                    //EditPage()

                }

            }
        }
    }


}

