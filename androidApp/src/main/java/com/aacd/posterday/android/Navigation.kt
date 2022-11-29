package com.aacd.posterday.android

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.PostersViewModel
import com.aacd.posterday.android.ui.screens.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

@Composable
fun Navigation(auth: FirebaseAuth, viewModel: PostersViewModel) {
    val navController = rememberNavController()
    val _auth = FirebaseAuth.getInstance();
    viewModel.getPosters()
    val loggedIn = _auth.currentUser != null
    val posterList = viewModel.posterList
//TODO: MAKE IT LOGOUT ON BACK BUTTON FROM MAIN MENU

    NavHost(
        navController = navController,
        startDestination = if(loggedIn)Screen.MainMenu.route else Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController, modifier = Modifier,auth = _auth,viewModel = viewModel)
        }
        composable(
            route = Screen.DetailScreen.route +"/{teamId}/{projectName}/{teamName}/{subject}",//or use"?name={name}" for optional
            arguments = listOf(
                navArgument(name = "teamId") {
                    type = NavType.StringType
                    defaultValue = "tid"
                }, navArgument(name = "projectName") {
                    type = NavType.StringType
                    defaultValue = "project name"
                }, navArgument(name = "teamName") {
                    type = NavType.StringType
                    defaultValue = "team name"
                }, navArgument(name = "subject") {
                    type = NavType.StringType
                    defaultValue = "Computer Science"
                }

            )
        ) { entry ->
            DetailScreen(navController = navController,
                teamId = entry.arguments?.getString("teamId")!!,
                projectName = entry.arguments?.getString("projectName")!!,
                teamName = entry.arguments?.getString("teamName")!!,
                subject = entry.arguments?.getString("subject")!!,
                role = viewModel.role,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
        composable(
            route = Screen.MainMenu.route
        ){ entry ->
            MainMenu(navController = navController,
                modifier = Modifier
                    .fillMaxWidth(),
                auth = _auth,
                viewModel = viewModel
            )

        }
        composable(
            route = Screen.RegisterScreen.route
        ){ entry ->
            RegisterScreen(navController = navController,
                modifier = Modifier
                    .fillMaxWidth(),
            )

        }
        composable(
            route = Screen.CategoryScreen.route
        ){ entry ->
            CategoryScreen(navController = navController,
                modifier = Modifier
                    .fillMaxWidth(),
                auth = _auth,
                viewModel = viewModel
            )

        }
        composable(
            route = Screen.WinnerScreen.route
        ){ entry ->
            WinnerScreen(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth(),
                viewModel = viewModel
            )

        }

        composable(
            route = Screen.PostersScreen.route
        ){ entry ->
            PostersScreen(navController = navController,
                modifier = Modifier
                    .fillMaxWidth(),
                posterList = posterList,
                viewModel = viewModel,
                role = viewModel.role
            )
        }
        composable(
            route = Screen.InfoScreen.route
        ){ entry ->
            InfoScreen(navController = navController,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }

        composable(
            route = Screen.RubricScreen.route +"/{teamId}",//or use"?name={name}" for optional
            arguments = listOf(
                navArgument(name = "teamId") {
                    type = NavType.StringType
                    defaultValue = "tid"
                }

            )
        ) { entry ->
            RubricScreen(navController = navController,
                teamId = entry.arguments?.getString("teamId")!!,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}
