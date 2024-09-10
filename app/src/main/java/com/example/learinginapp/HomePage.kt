package com.example.learinginapp

import android.widget.ImageButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class Item(val name: String, val description: String)

@OptIn(ExperimentalFoundationApi::class)


@Composable

fun HOmnePage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 105.dp
                    )
                )
                .background(Color(0xB2040B3F))
        ) {
            Image(
                painter = painterResource(id = R.drawable.edu),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 120.dp, start = 30.dp)
                    .size(80.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 50.dp,
                            bottomEnd = 50.dp,
                            topStart = 50.dp,
                            topEnd = 50.dp
                        )
                    )
            )
            Text(
                text = "Hello,",
                modifier = Modifier
                    .padding(start = 140.dp, top = 125.dp), fontSize = 30.sp, color = Color.White
            )
            Text(
                text = "Begin your learning journey today",
                modifier = Modifier
                    .padding(start = 140.dp, top = 170.dp), fontSize = 25.sp, color = Color.White
            )


        }

        Box(
            modifier = Modifier
                .padding(top = 370.dp)
                .width(300.dp)
                .height(70.dp)
                .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))
                .align(Alignment.TopCenter)
        ) {
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                )
            ) {
                Text(text = "CONTINUE AS A GUEST")
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 460.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 40.dp)
                    .width(130.dp)
                    .height(60.dp)
                    .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

            ) {
                Button(
                    onClick = { navController.navigate("Sing_In") }, modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    )
                ) {
                    Text(text = "SIGN IN")
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .width(180.dp)
                    .height(60.dp)
                    .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

            ) {
                Button(
                    onClick = { navController.navigate("Sing_Up") }, modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xB2040B3F),
                        contentColor = Color.White,
                    )
                ) {
                    Text(text = "CREATE A ACCOUNT")
                }
            }

        }
        Text(
            text = "Or you can continue Sign in with",
            modifier = Modifier
                .padding(top = 600.dp)
                .align(Alignment.TopCenter), fontSize = 14.sp
        )
        Row(
            modifier = Modifier
                .padding(top = 650.dp)
                .fillMaxWidth()
        ) {
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
        Row(modifier = Modifier.padding(top = 750.dp, start = 80.dp)) {
            Text(text = "By clicking", modifier = Modifier.padding(top = 11.dp), fontSize = 15.sp)
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Terms & Condition", modifier = Modifier, fontSize = 15.sp)
            }
            Text(text = "apply", modifier = Modifier.padding(top = 11.dp), fontSize = 15.sp)

        }

    }
}