package com.aacd.posterday.android

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aacd.posterday.android.ui.MenuViewModel
import com.aacd.posterday.android.ui.screens.DetailScreen
import com.aacd.posterday.android.ui.screens.LoginScreen
import com.aacd.posterday.android.ui.screens.MainMenu

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = Screen.MainMenu.route) {
        composable(route = Screen.MainMenu.route) {
            val viewModel = viewModel<MenuViewModel>();
            MainMenu(navController = navController, onAction = viewModel::onAction)
        }
        composable(
            route = Screen.DetailScreen.route +"/{name}" ,//or use"?name={name}" for optional
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "Andrew"
                    nullable = true
                }
            )
        ) { entry ->
            DetailScreen(navController = navController, name = entry.arguments?.getString("name"),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        composable(
            route = Screen.LoginScreen.route
        ){ entry ->
            LoginScreen(navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

    }
}
