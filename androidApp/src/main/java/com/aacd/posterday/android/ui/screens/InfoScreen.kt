package com.aacd.posterday.android.ui.screens

import android.util.Log.d
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import com.aacd.posterday.android.R
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawCacheModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun InfoScreen(
    navController: NavController,
    modifier: Modifier
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(60.dp, 40.dp, 60.dp, 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.votebot), contentDescription = "Vote bot icon",
        modifier = Modifier.height(100.dp))

        Spacer(modifier = Modifier.heightIn(10.dp))

        Text(
            text = "About Votebot",
            color= Color.White,
            fontSize = 36.sp
        )

        Spacer(modifier = Modifier.heightIn(20.dp))
        Card(
            backgroundColor = Color.White
        ) {
            Text(
                text = "This app was created for CSC 4350 - Software Engineering. Click [ Posters ] to be taken to a category screen. From there, choose between [Undergrad], [Master's], and [Doctoral]. The next screen is a list of poster entries. Click on the Project name to the right, and it will navigate to a detail screen for the psoter. If your role is Judge or Admin, you will be able to see the rubric button.",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(all = 20.dp)
            )
        }
    }
}
