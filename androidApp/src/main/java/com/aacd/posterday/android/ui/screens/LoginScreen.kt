package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.ui.actions.MenuButtonAction
import com.aacd.posterday.android.ui.components.InputText
import com.aacd.posterday.android.ui.components.MenuButton

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier,

) {
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =  Arrangement.Top
    ){
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Welcome",
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            modifier = Modifier
            )
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical=10.dp)
            .shadow(30.dp, shape = RoundedCornerShape(10), ambientColor = Color.Black, spotColor = Color.Black),
            shape = RoundedCornerShape(10),
            border = BorderStroke(3.dp,Color.Black),

            )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement =  Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .background(color = Color.White)
            ) {

                OutlinedTextField(
                    value = email, onValueChange ={email = it},
                    label = { Text(text = "Email")},
                    placeholder = { Text(text = "abc@domain.com")},
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 15.dp, 15.dp, 5.dp),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                    )
                OutlinedTextField(
                    value = password, onValueChange ={password = it},
                    label = { Text(text = "Password")},
                    placeholder = { Text(text = "abc@domain.com")},
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 5.dp, 15.dp, 20.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
            }
        }
    }
}