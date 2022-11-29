package com.aacd.posterday.android.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.states.RubricState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PostersViewModel: ViewModel(

) {
    val _auth = FirebaseAuth.getInstance()
    val _db = FirebaseFirestore.getInstance()
    val posterPath = _db.collection("posters")
    var posterList: MutableList<Poster> = mutableListOf()
    var role: String = ""


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
    fun checkRole(){
        println("checking role")
        var doc : Any?
        GlobalScope.launch(){

            println("inside GlobalScope: " + System.currentTimeMillis())
            println(_auth.currentUser!!.uid)
            doc = _db.collection("users").document(_auth.currentUser!!.uid).get().addOnCompleteListener {
                if(it.isSuccessful) {
                    doc = it.result
                    role = (doc as DocumentSnapshot?)!!.get("role").toString()
                    println("this is the print inside: " + role + " " + System.currentTimeMillis())
                }
            }
        }
        println(role)
    }

    fun getWinner(){
        
    }


}