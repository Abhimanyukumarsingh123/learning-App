package com.example.learinginapp

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.collection.emptyLongSet
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import org.intellij.lang.annotations.Language
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

//@Preview(showBackground = true)
@Composable
fun StudentDetails( navController: NavController) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    var schoolText by remember { mutableStateOf(TextFieldValue()) }

    // Separate states for dropdown menus
    var expendedCountry by remember { mutableStateOf(false) }
    var expendedState by remember { mutableStateOf(false) }
    var expendedBoard by remember { mutableStateOf(false) }
    var expendedClass by remember { mutableStateOf(false) }
    var expendedlanguage by remember { mutableStateOf(false) }

    val countryList = listOf("Belize", "Bhutan", "China", "Nepal", "India")
    var selectedCountry by remember { mutableStateOf("") }

    val stateList = listOf("State1", "State2", "State3", "State4")
    var selectedState by remember { mutableStateOf("") }

    val boardList = listOf(
        "BSEB(Bihar School Examination Board)",
        "CBSE(Central Board of Secondary Education)",
        "UP Board",
    )
    var selectedBord by remember { mutableStateOf("") }

    val classList = listOf("9th", "10th", "11th", "12th")
    var selectedClass by remember { mutableStateOf("") }

    val languageList = listOf("English", "Hindi", "Bhojpuri", "Nepali", "Panjabi")
    var selectedLanguage by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val countryIcon =
        if (expendedCountry) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val stateIcon =
        if (expendedState) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    var selectedDate by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }

    if (showDatePicker) {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                showDatePicker = false
            },
            year, month, day
        ).show()
    }



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
            IconButton(
                onClick = { navController.navigate("Home_page") },
                modifier = Modifier.padding(top = 30.dp, start = 30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier, Color.White
                )
            }

            Text(
                text = "Student Details",
                modifier = Modifier.padding(top = 80.dp, start = 50.dp),
                Color.White, fontSize = 25.sp
            )
            Text(
                text = "Please provide the student details to personalize their learning",
                modifier = Modifier.padding(top = 120.dp, start = 50.dp, end = 20.dp),
                Color.White, fontSize = 20.sp
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 150.dp, end = 30.dp)
                    .drawBehind {
                        // Draw the underline
                        drawLine(
                            color = Color.White,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 2.dp.toPx()
                        )
                    }
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = { newValue ->
                        text = newValue
                    },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White,
                        fontSize = 20.sp
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 210.dp)

                )
                if (text.text.isEmpty()) {
                    Text(
                        text = "Name",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.White.copy(alpha = 0.8f), // Placeholder color
                            fontSize = 20.sp
                        ),
                        modifier = Modifier
                            .padding(top = 210.dp)
                            .align(Alignment.CenterStart) // Center the placeholder
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.cssssssssss),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 200.dp, start = 70.dp)
                    .size(60.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 100.dp,
                            bottomEnd = 100.dp,
                            topStart = 100.dp,
                            topEnd = 100.dp
                        )
                    )
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 230.dp, start = 105.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 100.dp,
                            bottomEnd = 100.dp,
                            topStart = 100.dp,
                            topEnd = 100.dp
                        )
                    )
                    .background(Color(0xB2CABDAF))
                    .size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }

        }
        Column(modifier = Modifier.padding(top = 340.dp, start = 30.dp, end = 30.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = selectedDate,
                    onValueChange = {},
                    label = { Text(text = "Date of Birth") },
                    placeholder = { Text("Date of Birth (DD/MM/YYYY)") },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.Black)
                        .padding(end = 100.dp) // Padding to make space for button
                )
                Button(
                    onClick = { showDatePicker = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 200.dp)
                        .size(width = 120.dp, height = 40.dp)
                ) {
                    Text(text = "Select", fontSize = 14.sp)
                }
            }
            Spacer(modifier = Modifier.padding(top = 17.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = selectedCountry,
                    onValueChange = { selectedCountry = it },
                    modifier = Modifier
                        .weight(1f)
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Select Country") },
                    trailingIcon = {
                        Icon(
                            countryIcon,
                            "",
                            Modifier.clickable { expendedCountry = !expendedCountry })
                    },
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = selectedState,
                    onValueChange = { selectedState = it },
                    modifier = Modifier
                        .weight(1f)
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Select State") },
                    trailingIcon = {
                        Icon(stateIcon, "", Modifier.clickable { expendedState = !expendedState })
                    },
                    maxLines = 1
                )
            }
            DropdownMenu(
                expanded = expendedCountry,
                onDismissRequest = { expendedCountry = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                countryList.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedCountry = label
                        expendedCountry = false
                    }) {
                        Text(text = label)
                    }
                }
            }
            DropdownMenu(
                expanded = expendedState,
                onDismissRequest = { expendedState = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                stateList.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedState = label
                        expendedState = false
                    }) {
                        Text(text = label)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 17.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = selectedBord,
                    onValueChange = { selectedBord = it },
                    modifier = Modifier
                        .weight(1f)
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Select Board") },
                    trailingIcon = {
                        Icon(countryIcon, "", Modifier.clickable { expendedBoard = !expendedBoard })
                    },
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = selectedClass,
                    onValueChange = { selectedClass = it },
                    modifier = Modifier
                        .weight(1f)
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Select State") },
                    trailingIcon = {
                        Icon(stateIcon, "", Modifier.clickable { expendedClass = !expendedClass })
                    },
                    maxLines = 1
                )
            }
            DropdownMenu(
                expanded = expendedBoard,
                onDismissRequest = { expendedBoard = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                boardList.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedBord = label
                        expendedBoard = false
                    }) {
                        Text(text = label)
                    }
                }
            }
            DropdownMenu(
                expanded = expendedClass,
                onDismissRequest = { expendedClass = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
            ) {
                classList.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedClass = label
                        expendedClass = false
                    }) {
                        Text(text = label)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 17.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = selectedLanguage,
                    onValueChange = { selectedLanguage = it },
                    modifier = Modifier
                        .weight(1f)
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Select Language") },
                    trailingIcon = {
                        Icon(
                            countryIcon,
                            "",
                            Modifier.clickable { expendedlanguage = !expendedlanguage })
                    },
                    maxLines = 1
                )
                DropdownMenu(
                    expanded = expendedlanguage,
                    onDismissRequest = { expendedlanguage = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                ) {
                    languageList.forEach { label ->
                        DropdownMenuItem(onClick = {
                            selectedLanguage = label
                            expendedlanguage = false
                        }) {
                            Text(text = label)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 17.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(start = 150.dp, end = 30.dp)
                    .drawBehind {
                        // Draw the underline
                        drawLine(
                            color = (Color(0xD8504E4B)),
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 1.5f.dp.toPx()
                        )
                    }
            ) {
                BasicTextField(
                    value = schoolText,
                    onValueChange = { newValue ->
                        schoolText = newValue
                    },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontSize = 20.sp
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()

                )
                if (schoolText.text.isEmpty()) {
                    Text(
                        text = "School (Optional)",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = (Color(0xD8504E4B)), // Placeholder color
                            fontSize = 17.sp
                        ),

                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 25.dp))
            Box(
                modifier = Modifier

                    .width(320.dp)
                    .height(60.dp)
                    .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(5.dp))

            ) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.TopCenter), shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = (Color(0x8BCFCAC1)),
                        contentColor = Color.Black,
                    )
                ) {
                    Text(text = "CREATE PROFILE")
                }
            }
        }
    }
}