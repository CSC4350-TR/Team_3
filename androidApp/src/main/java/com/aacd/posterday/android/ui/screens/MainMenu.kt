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

@Composable
fun MainMenu(
    navController: NavController,
    modifier: Modifier = Modifier,
    onAction: (MenuButtonAction) -> Unit,

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

            MenuButton(displayText = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                }
            )
            MenuButton(displayText = "two",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                    onAction(MenuButtonAction.Submit)
                }
            )
            TextField(value = text, onValueChange = {
                text = it
            },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                             navController.navigate(Screen.LoginScreen.route);
                             },
            modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "nextScreen")
            }

        }

    }
}