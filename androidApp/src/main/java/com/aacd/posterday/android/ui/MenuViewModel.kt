package com.aacd.posterday.android.ui

import androidx.lifecycle.ViewModel
import com.aacd.posterday.android.ui.actions.MenuButtonAction

class MenuViewModel: ViewModel() {


    fun onAction(action: MenuButtonAction){
        when(action) {
            is MenuButtonAction.Navigate -> navigateTo(action.destination)
            is MenuButtonAction.Submit -> submit()
            is MenuButtonAction.Upload -> upload()
        }
    }

    fun navigateTo(destination: String){
        println("navigate button pressed" + destination)
    }

    fun submit(){
        println("submit button pressed")
    }
    fun upload(){
        println("upload button pressed")
    }
}