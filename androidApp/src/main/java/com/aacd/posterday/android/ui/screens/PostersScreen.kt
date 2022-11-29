package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.PostersViewModel
import com.aacd.posterday.android.ui.components.ListItem

@Composable
fun PostersScreen(
   
    navController: NavController,
    modifier: Modifier,
    posterList: MutableList<Poster>,
    viewModel: PostersViewModel,
    role: String
){
    val viewModel: PostersViewModel = PostersViewModel()
    Column(modifier=Modifier.fillMaxSize()) {


//        Button(onClick = { viewModel.getPosters() }) {
//            Text(text = "get posters")
//        }
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {

            items(items = posterList) { poster ->
                var teamId = poster.teamId
                ListItem(
                    projectName = poster.projectName,
                    teamName = poster.teamName,
                    subject = poster.subject,
                    onClick = {
                        navController.navigate(
                            Screen.DetailScreen.withArgs(
                                teamId,
                                poster.projectName,
                                poster.teamName
                            )
                        )
                    }
                )
            }

        }
    }
}

