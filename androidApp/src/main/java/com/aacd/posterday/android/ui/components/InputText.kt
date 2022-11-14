package com.aacd.posterday.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp

@Composable
fun InputText (
    displayText: String,
    modifier: androidx.compose.ui.Modifier,
    onClick: ()-> Unit
    ){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it }
    )
    Text("The textfield has this text: " + textState.value.text)
    }

