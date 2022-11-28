package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.aacd.posterday.android.Screen

@Composable
fun DetailScreen(
    navController: NavController,
    projectName: String,
    teamName: String,
    teamId: String,
    modifier: Modifier

) {
    Column {
        Text(text = projectName)
        Text(text = teamName)
        Button(
            onClick = { navController.navigate(Screen.RubricScreen.route) }
        ) {
            Text(text = "Rubric")
        }
    }


}