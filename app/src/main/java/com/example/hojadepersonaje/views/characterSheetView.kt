package com.example.hojadepersonaje.views

import android.graphics.drawable.shapes.Shape
import android.util.Log
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
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.hojadepersonaje.MainActivity.CharacterSheet
import com.example.hojadepersonaje.MainActivity.Home
import com.example.hojadepersonaje.characterdata.Action
import com.example.hojadepersonaje.characterdata.CharacterProperty
import com.example.hojadepersonaje.characterdata.Item
import com.example.hojadepersonaje.characterdata.RPCharacter
import com.example.hojadepersonaje.characterdata.Spell
import com.example.hojadepersonaje.characterdata.Weapon
import com.example.hojadepersonaje.composables.CharacterInfoCard
import com.example.hojadepersonaje.composables.NewItemPopup
import com.example.hojadepersonaje.ui.theme.HojaDePersonajeTheme

@Composable
fun CharacterSheetView(){



}

@Composable
fun CharacterSheetView(character: RPCharacter,popBackStack:()->Unit){

    val showNewCharacterProperty= remember { mutableStateOf(false) }
    var newCharacterProperty: CharacterProperty= CharacterProperty()
    var newPropertyTxt= rememberTextFieldState()

    Surface(color = MaterialTheme.colorScheme.surface,modifier=Modifier) {

        NewItemPopup(
            showDialog = showNewCharacterProperty.value,
            title="New Property",
            onDismiss = { showNewCharacterProperty.value = false },
            onConfirm = {

                when (newCharacterProperty) {
                    is Weapon->
                        character.strikes.add(newCharacterProperty as Weapon)
                    is Action->
                        character.actionList.add(newCharacterProperty as Action)
                    is Spell ->
                        character.spells.add(newCharacterProperty as Spell)
                    is Item->
                        character.inventory.add(newCharacterProperty as Item)
                }


            }
        ) {
            TextField(
                state=newPropertyTxt,
                label= { Text("New Property") }
            )
        }



        Column(modifier=Modifier.fillMaxSize()) {

            Row(modifier=Modifier
                .fillMaxHeight(0.1f)
                .fillMaxWidth())
            {
                Box(modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth(0.216f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = AbsoluteRoundedCornerShape(8.dp)
                    )

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

                val backStack= remember{ mutableStateListOf<Any>(Menu) }

                NavDisplay(
                    backStack=backStack,
                    onBack={
                        backStack.removeLastOrNull()},
                    entryProvider={
                            key->
                        when(key){
                            is Menu-> NavEntry(key) {
                                ChInfo({infoScreenNav->


                                    backStack.add(infoScreenNav)},character)
                            }
                            is InfoScreen->NavEntry(key){inf->

                                    val infoScreen =inf as InfoScreen
                                try{
                                    Log.println(Log.DEBUG,"InfoScreenDebug"
                                        ,"InfoScreen Size ${infoScreen.info.size}")
                                }catch (e:Exception){
                                    e.printStackTrace()
                                }

                                    when (infoScreen.info[0]) {
                                        is Action -> {
                                            DescriptionView(character.actionList){
                                                newCharacterProperty= Action("",0)
                                                showNewCharacterProperty.value=true
                                            }


                                        }

                                        is Spell -> {
                                            DescriptionView(character.spells){

                                            }
                                        }

                                        is Weapon -> {
                                            /*DescriptionView(character.strikes){TODO
                                                s->
                                                character.strikes.add(s)
                                            }*/
                                        }

                                        is Item -> {
                                            DescriptionView(character.inventory){

                                            }
                                        }

                                    }



                            }
                            else->NavEntry(key=Unit){
                                Text(text="Error de navegacion 2${key.toString()}")//TODO Error de navegacion
                            }
                        }
                    }
                )

            }


        }

    }

}



@Composable fun ChInfo(infoScreenNav:(destination:InfoScreen)->Unit,character: RPCharacter){
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
                color = MaterialTheme.colorScheme.primary,
                shape = AbsoluteRoundedCornerShape(8.dp)
            )
            .height(140.dp)
            .padding(8.dp)
        Row(horizontalArrangement = Arrangement.SpaceEvenly
            ,modifier=Modifier.fillMaxSize()) {

            CharacterInfoCard(
                modifier=Modifier.fillMaxWidth(0.5f),
                text="Actions",
                onClick = {

                    infoScreenNav(InfoScreen(character.actionList))
                })
            CharacterInfoCard(
                modifier = Modifier.fillMaxWidth(),
                text = "Spells",
                onClick = {
                    infoScreenNav(InfoScreen(character.spells))
                }
            )
        }
        Row() {

        }
        Row() {

        }


        Row(){

        }
    }}

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


data object Menu
data class InfoScreen(var info: List<CharacterProperty>)
data object CharacterScreen