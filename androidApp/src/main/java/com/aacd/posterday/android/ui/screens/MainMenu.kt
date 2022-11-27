package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.ui.actions.MenuButtonAction
import com.aacd.posterday.android.ui.components.InputText
import com.aacd.posterday.android.ui.components.MenuButton
import com.google.firebase.auth.FirebaseAuth

@Composable
fun MainMenu(
    navController: NavController,
    modifier: Modifier = Modifier,
    auth: FirebaseAuth
) {
    var text by remember{
        mutableStateOf("")
    }
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .heightIn(50.dp))

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
                displayText = "Other Action",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                }
            )

            MenuButton(
                displayText = "Posters",
                modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
                onClick = {
                    navController.navigate(Screen.PostersScreen.route)
                },
            )

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
        }
    }
}