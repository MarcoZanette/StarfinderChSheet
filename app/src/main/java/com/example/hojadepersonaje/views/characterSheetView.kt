package com.example.hojadepersonaje.views

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hojadepersonaje.characterdata.RPCharacter
import com.example.hojadepersonaje.composables.CharacterInfoCard
import com.example.hojadepersonaje.ui.theme.HojaDePersonajeTheme

@Composable
fun CharacterSheetView(){



}

@Composable
fun CharacterSheetView(character: RPCharacter,popBackStack:()->Unit){

    Surface(color = MaterialTheme.colorScheme.surface,modifier=Modifier) {
        Column(modifier=Modifier.fillMaxSize()) {

            Row(modifier=Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth())
            {
                Box(modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth(0.216f)
                    .border(width = 1.dp, color= MaterialTheme.colorScheme.outline, shape = AbsoluteRoundedCornerShape(8.dp))

                )

                {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.outline),
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(2.dp)
                    ) {
                        //retrato del pj
                    }
                }
                Text(text="Nombre del personaje",modifier=Modifier
                    .padding(1.dp)
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = AbsoluteRoundedCornerShape(8.dp)
                    ))
            }


            Row(modifier=Modifier.fillMaxHeight()) {
                Column(modifier=Modifier
                    .padding(1.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(0.216f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = AbsoluteRoundedCornerShape(8.dp)
                    )) {

                }
                Column(modifier=Modifier
                    .padding(1.dp)
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = AbsoluteRoundedCornerShape(8.dp)
                    )

                ) {
                    val infoCardMod=Modifier
                        .padding(2.dp)
                        .border(
                            width = 1.dp,
                            color=MaterialTheme.colorScheme.primary,
                            shape= AbsoluteRoundedCornerShape(8.dp)
                        )
                        .height(140.dp)
                        .padding(8.dp)
                    Row(horizontalArrangement = Arrangement.SpaceEvenly
                        ,modifier=Modifier.fillMaxSize()) {

                        CharacterInfoCard(
                            modifier=Modifier.fillMaxWidth(0.5f),
                            text="Actions",
                            onClick = {

                            })
                        CharacterInfoCard(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Spells",
                            onClick = {

                            }
                        )
                    }
                    Row() {

                    }
                    Row() {

                    }


                    Row(){

                    }
                }
            }


        }

    }

}


@Composable
fun ChMenuItem(modifier: Modifier =Modifier){
    Box(modifier=modifier){

    }
}

@Preview
@Composable
fun ChsPrev(){
    var ch= RPCharacter(0,"Npc")
    CharacterSheetView(ch,{})
}