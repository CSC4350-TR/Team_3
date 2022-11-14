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
fun DetailScreen(
    navController: NavController,
    name: String?,
    modifier: Modifier

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

            MenuButton(displayText = "one",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                    println("one clicked")
                }
            )
            MenuButton(displayText = "two",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan),

                onClick = {
                   println("clicked something")
                }
            )
            TextField(value = text, onValueChange = {
                text = it
            },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                             navController.navigate(Screen.MainMenu.route)
                             },
            modifier = Modifier.fillMaxWidth()
            ) {
                name?.let { Text(text = it) }
            }

        }

    }
}