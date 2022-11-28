package com.aacd.posterday.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListItem(
    projectName: String,
    teamName: String,
    subject: String,
    onClick: () -> Unit
    //image: ?
){
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column(modifier = Modifier.weight(1f)) {
                   Text(text = teamName)
                   Text(text = subject) 
                }
                
                Button(onClick = onClick){
                    Text(text = projectName)
                }
            }
        }
    }
}