package com.aacd.posterday.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.aacd.posterday.android.ui.components.CustomOutlinedTextField

@Composable
fun RubricScreen(
    navController: NavController,
    modifier: Modifier,
    teamId: String,
){
    val _db = FirebaseFirestore.getInstance()
    val _auth = FirebaseAuth.getInstance()
    val currentUser = _auth.currentUser

    var creativity by rememberSaveable { mutableStateOf("") }
    var overall by rememberSaveable { mutableStateOf("") }
    var poster by rememberSaveable { mutableStateOf("") }
    var elevatorPitch by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {

        CustomOutlinedTextField(
            value = creativity,
            label = "Creativity",
            onValueChange = {creativity = it},
            leadingIconImageVector = Icons.Default.Numbers,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions()
        )

        CustomOutlinedTextField(
            value = elevatorPitch,
            label = "Elevator Pitch",
            onValueChange = {elevatorPitch = it} ,
            leadingIconImageVector = Icons.Default.Numbers,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        CustomOutlinedTextField(
            value = poster,
            label = "Poster",
            onValueChange = {poster = it} ,
            leadingIconImageVector = Icons.Default.Numbers,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )

        )

        CustomOutlinedTextField(
            value = overall,
            label = "Overall",
            onValueChange = {overall = it} ,
            leadingIconImageVector = Icons.Default.Numbers,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )



        Button(onClick = { _db.collection("posters").document(teamId).collection("scores").document(currentUser!!.uid).set(
            hashMapOf(
                "creativity" to creativity,
                "overall" to overall,
                "poster" to poster,
                "elevatorPitch" to elevatorPitch
            )
        )
        }
        ) {
            Text(text = "Submit")
        }
    }
}