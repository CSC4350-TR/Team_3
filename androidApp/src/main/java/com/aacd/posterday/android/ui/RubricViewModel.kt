package com.aacd.posterday.android.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aacd.posterday.android.ui.states.RubricState

class RubricViewModel: ViewModel() {

    var state by mutableStateOf(RubricState())
        private set

}