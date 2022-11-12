package com.aacd.posterday.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//reusable component for making android ui buttons
@Composable
fun MenuButton(
    displayText: String,
    modifier: androidx.compose.ui.Modifier,
    onClick: ()-> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = androidx.compose.ui.Modifier
            .clip(CircleShape)
            .clickable { onClick()}
            .then(modifier)
    ) {
        Text(
            text = displayText,
            fontSize = 36.sp,
            color = Color.Black
        )

    }
}
