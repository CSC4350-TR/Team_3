package com.aacd.posterday.android.ui.screens

import android.nfc.Tag
import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aacd.posterday.android.R
import com.aacd.posterday.android.Screen
import com.aacd.posterday.android.ui.PostersViewModel
import com.aacd.posterday.android.ui.actions.MenuButtonAction
import com.aacd.posterday.android.ui.components.InputText
import com.aacd.posterday.android.ui.components.MenuButton
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier,
    auth: FirebaseAuth,
    viewModel: PostersViewModel

) {
    val focusManager = LocalFocusManager.current;
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val isEmailValid  by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    val isPasswordValid by derivedStateOf {
        password.length > 7
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(painter = painterResource(id = R.drawable.votebot), contentDescription = "vote bot icon" )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Welcome to Votebot",
            fontFamily = FontFamily.SansSerif,
            fontSize = 25.sp,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(30.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .shadow(
                    30.dp,
                    shape = RoundedCornerShape(10),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                ),
            shape = RoundedCornerShape(10),
            border = BorderStroke(3.dp, Color.Black),

            )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .background(color = Color.White)
            ) {

                OutlinedTextField(
                    value = email, onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "abc@domain.com") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 15.dp, 15.dp, 5.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    isError = !isEmailValid,
                    trailingIcon = {
                        if(email.isNotBlank()){
                            IconButton(onClick = {email = ""}){
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = "Clear email",
                                )
                            }
                        }
                    }
                )
                OutlinedTextField(
                    value = password, onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "$#@!&") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 5.dp, 15.dp, 15.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    isError = !isPasswordValid,
                    trailingIcon = {
                            IconButton(onClick = {isPasswordVisible = !isPasswordVisible }){
                                Icon(
                                    imageVector = if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle Visibility",
                                )
                            }
                    },
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                )
                Button(
                    onClick = {
                              auth.signInWithEmailAndPassword(email,password)
                                  .addOnCompleteListener {
                                      if (it.isSuccessful){
                                          Log.d("auth","success");
                                          viewModel.checkRole()
                                          navController.navigate(Screen.MainMenu.route)
                                      }
                                      else{
                                          Log.d("","error signing in")
                                      }
                                  }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 0.dp, 15.dp, 25.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    enabled = isEmailValid && isPasswordValid
                ) {
                    Text(text = "Log in",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp)
                }
            }

        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
        ) {
            TextButton(
                onClick = { /*TODO*/ }) {
                Text(
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp,
                    text = "Forgot Password",
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
        Button(
            onClick = {
                navController.navigate(Screen.RegisterScreen.route);
            },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        ) {
            Text(
                text = "Register",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}