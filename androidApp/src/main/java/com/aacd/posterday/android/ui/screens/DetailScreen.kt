package com.aacd.posterday.android.ui.screens

import android.media.Image
import android.text.Html.ImageGetter
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aacd.posterday.android.R
import com.aacd.posterday.android.Screen

@Composable
fun DetailScreen(
    navController: NavController,
    projectName: String,
    teamName: String,
    teamId: String,
    modifier: Modifier

) {


    Column(
        modifier = Modifier
            .fillMaxSize(0.9f)
            .padding(horizontal = 30.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {

        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.periodic_table), contentDescription = "chem poster" )

        Text(
            text = projectName,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White

            )
        Text(
            text = teamName,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Button(
            onClick = { navController.navigate(Screen.RubricScreen.withArgs(teamId)) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Rubric")
        }
    }


}