package com.aacd.posterday.android.ui.actions

sealed class MenuButtonAction {
    data class Navigate(val destination: String): MenuButtonAction()
    object Upload: MenuButtonAction()
    object Submit: MenuButtonAction()

}
