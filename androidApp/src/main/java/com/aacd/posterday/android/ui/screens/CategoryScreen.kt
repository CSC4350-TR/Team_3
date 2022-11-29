package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aacd.posterday.android.R
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.ui.PostersViewModel
import com.aacd.posterday.android.ui.components.MenuButton
import com.google.firebase.auth.FirebaseAuth

@Composable
fun CategoryScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    auth: FirebaseAuth,
    viewModel: PostersViewModel
){
    Box(modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .heightIn(110.dp))

            MenuButton(
                displayText = "Undergrad",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                onClick = {
                    navController.navigate(Screen.PostersScreen.route)
                },
            )
            MenuButton(
                displayText = "Master's",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                onClick = {
                    navController.navigate(Screen.PostersScreen.route)
                },
            )
            MenuButton(
                displayText = "Doctoral",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                onClick = {
                    navController.navigate(Screen.PostersScreen.route)
                },
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .heightIn(50.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.votebot),
                contentDescription = "vote bot icon",
                modifier = Modifier
                    .height(50.dp)
                ,

                )
        }
    }
}