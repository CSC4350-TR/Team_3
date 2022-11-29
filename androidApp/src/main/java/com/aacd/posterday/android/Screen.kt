package com.aacd.posterday.android

import com.google.common.io.Files.append

sealed class Screen(val route: String){
    object MainMenu: Screen("mainmenu_screen")
    object DetailScreen: Screen("detail_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object PostersScreen: Screen("posters_screen")
    object InfoScreen: Screen("info_screen")
    object RubricScreen: Screen("rubric_screen")
    object CategoryScreen: Screen("category_screen")
    object WinnerScreen: Screen("winner_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
