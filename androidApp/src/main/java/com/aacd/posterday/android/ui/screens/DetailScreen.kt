package com.aacd.posterday.android.ui.screens

import android.media.Image
import android.text.Html.ImageGetter
import android.widget.ImageView
import androidx.compose.foundation.Image
import kotlinx.coroutines.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aacd.posterday.android.R
import com.aacd.posterday.android.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun DetailScreen(
    navController: NavController,
    projectName: String,
    teamName: String,
    teamId: String,
    subject: String,
    modifier: Modifier,
    role: String

) {

    val _auth = FirebaseAuth.getInstance()
    val _db = FirebaseFirestore.getInstance()
    val enableRubric = (role == "judge") || (role == "admin")




    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Image(
            painter = painterResource(id =
            if(teamName == "Green")R.drawable.poster_day else R.drawable.bad_poster),
            contentDescription = "Poster day poster",
            modifier = Modifier.fillMaxWidth()
            )
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = projectName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            )


        Text(
            text = teamName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = { navController.navigate(Screen.RubricScreen.withArgs(teamId)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .alpha(if(!enableRubric)0.0f else 100.0f),

            enabled = enableRubric,


        ) {
            Text(text = "Rubric")
        }
    }


}