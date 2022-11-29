package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aacd.posterday.android.R
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.ui.PostersViewModel
import com.aacd.posterday.android.ui.actions.MenuButtonAction
import com.aacd.posterday.android.ui.components.InputText
import com.aacd.posterday.android.ui.components.MenuButton
import com.google.firebase.auth.FirebaseAuth
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MainMenu(
    navController: NavController,
    modifier: Modifier = Modifier,
    auth: FirebaseAuth,
    viewModel: PostersViewModel
) {
    var role = viewModel.role
    var voteEnabled =  (role == "admin")

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .heightIn(150.dp)
            )

            MenuButton(
                displayText = "Info",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                    navController.navigate(Screen.InfoScreen.route)
                }
            )

            MenuButton(
                displayText = "Posters",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),
                onClick = {
                    navController.navigate(Screen.CategoryScreen.route)
                },
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(if(!voteEnabled)0.0f else 100.0f),
                onClick = {
                    navController.navigate(Screen.WinnerScreen.route)
                },
                enabled = voteEnabled,

            ){
                Text(text = "Count Votes")
            }

            MenuButton(
                displayText = "Logout",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                    auth.signOut()
                    navController.navigate(Screen.LoginScreen.route)
                },
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .heightIn(10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.votebot),
                contentDescription = "vote bot icon",
                modifier = Modifier
                    .height(50.dp)
                    .alpha(0.5f),

            )
        }
    }
}