package com.aacd.posterday.android.ui

import android.app.Application
import android.content.Context
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aacd.posterday.android.models.Poster
import com.aacd.posterday.android.ui.components.AlertPopup
import com.aacd.posterday.android.ui.screens.WinnerScreen
import com.aacd.posterday.android.ui.states.RubricState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.snapshots
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import org.checkerframework.common.value.qual.DoubleVal
import org.checkerframework.common.value.qual.IntVal

class PostersViewModel: ViewModel(

) {
    val _auth = FirebaseAuth.getInstance()
    val _db = FirebaseFirestore.getInstance()
    val posterPath = _db.collection("posters")
    var posterList: MutableList<Poster> = mutableListOf()
    var role: String = ""
    var winnerProject = mutableStateOf(" ")
    var winnerTeam = mutableStateOf(" ")


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

    suspend fun getWinner(){
        var posterDocs : MutableList<QueryDocumentSnapshot> = mutableListOf()
        var currentScore: Long = 0
        var currentTotal: Long = 0
        var scoreMap: MutableMap<String,Long> = mutableMapOf()
        var finalScores: MutableMap<String,Double> = mutableMapOf()


        //var teamTotal: Double = 0.0
        coroutineScope{
            posterPath
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("posterDocs", "${document.id} => ${document.data}")
                        posterDocs.add(document)
                    }
                    for (team in posterDocs) {
                        team.reference.collection("scores")
                            .get()
                            .addOnSuccessListener { result ->
                                for (score in result) {
                                    currentScore = score.get("total") as Long
                                    currentTotal += currentScore
                                    currentScore = 0
                                }
                                //println("team id: " +  team.id + "Current Total: " + currentTotal)
                                scoreMap[team.id] = currentTotal
                                println(scoreMap.size)
                                currentTotal = 0
                            }
                            .addOnFailureListener { exception ->
                                Log.w("scoring", "error")
                            }
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("gettingPosters", "Error getting documents.", exception)
                }
        }
        delay(2000)
        println(scoreMap.size)
        println("here")
        for (item in scoreMap) {
            println(item.key + ": " + item.value)
        }
                val result = scoreMap.toList().sortedByDescending { (_, value) -> value}
                for(poster in posterList){
                    if(poster.teamId == result[0].first) {
                        winnerProject.value = poster.projectName
                        winnerTeam.value = poster.teamName
                        println("The winner is: " + winnerProject.value)

                    }
                }
    }
}