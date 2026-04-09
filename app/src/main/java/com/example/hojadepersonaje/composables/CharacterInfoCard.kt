package com.example.hojadepersonaje.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
    fun RowScope.CharacterInfoCard(modifier:Modifier= Modifier, text:String="", onClick:()->Unit){
        Box(modifier=modifier
            .padding(1.dp)
            .border(
                width = 1.dp,
                color=MaterialTheme.colorScheme.primary,
                shape= AbsoluteRoundedCornerShape(8.dp)
            )
            .height(140.dp)
            .padding(2.dp))
        {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center)
                    .clickable(onClick = { onClick() })
            )
        }

    }


    @Preview
    @Composable
    private fun info() {
        Row {
            CharacterInfoCard(modifier = Modifier, text = "as", onClick = {})
        }
        }

