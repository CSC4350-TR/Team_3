package com.aacd.posterday.android.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.ui.PostersViewModel
import com.aacd.posterday.android.ui.components.AlertPopup
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
        Spacer(modifier = Modifier.heightIn(200.dp))
        Card (
            backgroundColor = MaterialTheme.colors.primary,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "The winner is: ",
                    fontSize = 36.sp,
                    modifier = Modifier.padding(all = 10.dp))
                Text(text = "Team " + viewModel.winnerTeam.value,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(all = 10.dp))
                Text(text = "Project: " + viewModel.winnerProject.value,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(all = 10.dp))

            }

        }
        Spacer(modifier = Modifier.heightIn(60.dp))
        Button(onClick = {
            viewModel.winnerProject.value = " ";
            viewModel.winnerTeam.value = " ";
            navController.navigate(Screen.MainMenu.route)
        } ) {
            Text(text = "Home")
        }
    }
    //AlertPopup(title = "Winner is: ", text = viewModel.winnerProject.value)
}