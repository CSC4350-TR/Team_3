package com.aacd.posterday.android.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.states.RubricState
import com.google.firebase.firestore.FirebaseFirestore

class PostersViewModel: ViewModel(

) {
    val _db = FirebaseFirestore.getInstance()

//    fun getPosters(): List<Poster>{
//       //List<> _db.collection("posters")
//    }

}