package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawCacheModifier
import androidx.navigation.NavController

@Composable
fun InfoScreen(
    navController: NavController,
    modifier: Modifier
){
    Column(modifier = Modifier.fillMaxSize(.9f)
    ) {
      Text(text = "Information")
    }
}
