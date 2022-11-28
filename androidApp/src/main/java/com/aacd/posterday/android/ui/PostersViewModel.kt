package com.aacd.posterday.android.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.states.RubricState
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots

class PostersViewModel: ViewModel(

) {
    val _db = FirebaseFirestore.getInstance()
    val posterPath = _db.collection("posters")
    //lateinit var posterRaw : MutableMap<String,Any>
    var posterList: MutableList<Poster> = mutableListOf();
    fun getPosters(){

        posterPath
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("gettingPosters", "${document.id} => ${document.data}")
                    posterList.add(Poster(
                        document.get("tid").toString(),
                        document.get("teamName").toString(),
                        document.get("projectName").toString(),
                        document.get("subject").toString())
                    )
                }
            }
            .addOnFailureListener { exception ->
                Log.w("gettingPosters", "Error getting documents.", exception)
            }
    }

}