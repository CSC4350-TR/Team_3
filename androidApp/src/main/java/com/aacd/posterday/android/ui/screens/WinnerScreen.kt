package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aacd.posterday.android.ui.PostersViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun WinnerScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PostersViewModel
){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.heightIn(100.dp))
        Card (
            backgroundColor = Color.Green,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "The winner is: ",
                    fontSize = 36.sp,
                    modifier = Modifier.padding(all = 10.dp))
                Text(text = "DEMO DAY!",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(all = 10.dp))
            }

        }
    }
}