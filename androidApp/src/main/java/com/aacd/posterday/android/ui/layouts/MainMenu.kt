package com.aacd.posterday.android.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aacd.posterday.android.ui.components.MenuButton

@Composable
fun MainMenu(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
            {
                Text(
                    text = "hello",
                    textAlign = TextAlign.End
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    MenuButton(displayText = "next",
                        modifier = Modifier
                            .background(Color.Cyan),
                        onClick = {
                            println("next clicked")
                        }
                    )
                        

                }
            }

    }
}