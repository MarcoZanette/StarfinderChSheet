package com.example.hojadepersonaje.composables

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DescriptionCard(val title:String,val content:@Composable ()->Unit)
{
    @Composable
    fun ShowCard() {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primary
        ){
            Column(modifier=Modifier.fillMaxWidth().
            border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = AbsoluteRoundedCornerShape(size = 8.dp)
            )) {

                Row(modifier=Modifier.fillMaxWidth().
                border(
                        width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = AbsoluteRoundedCornerShape(size = 8.dp)
                )){
                    Text(title)
                }


                Row() {content.invoke()}

            }

        }
    }
}


@Preview
@Composable
private fun Preview() {
    DescriptionCard("asd"){
        Text("Este es el textp qie se mpoestrrara dentropde ña tarketas")
    }.ShowCard()
}