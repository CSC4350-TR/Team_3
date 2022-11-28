package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.components.ListItem

@Composable
fun PostersScreen(
    navController: NavController,
    modifier: Modifier,
    posterList: List<Poster>
){

   LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
       items(items = posterList){poster ->

           ListItem(
               projectName = poster.projectName,
               teamName = poster.teamName,
               subject = poster.subject,
               onClick = {navController.navigate(Screen.DetailScreen.route)}
           )
       }
   }

}

