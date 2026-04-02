package com.example.hojadepersonaje.views

import android.os.Environment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.hojadepersonaje.R
import com.example.hojadepersonaje.characterdata.RPCharacter
import com.example.hojadepersonaje.composables.MenuBar
import com.example.hojadepersonaje.composables.MenuItem
import com.example.hojadepersonaje.composables.NewItemPopup
import com.example.hojadepersonaje.composables.RPCharCard
import com.example.hojadepersonaje.composables.SearchFilePopup

@Composable

fun MainMenuView(onRPCharLoad:(rpChar: RPCharacter)->Unit, onCreateNewRPChar:(name:String)->Unit, rpCharList:List<RPCharacter>){
    //Placeholders
    //--------------
    var showNewRPCharPopUp= remember{mutableStateOf(false)}
    var showLoadRPCharPopUp=remember{mutableStateOf(false)}
    var currentExternalDir=remember{mutableStateOf(Environment.getExternalStorageDirectory())}

    Surface(color = colorResource(R.color.white)) {
        var newItemState= remember{ TextFieldState() }
        NewItemPopup(
            showDialog=showNewRPCharPopUp.value,
            title= stringResource(R.string.newCharacter),
            text=stringResource(R.string.newCharacterName),
            onDismiss ={showNewRPCharPopUp.value=false},
            onConfirm = {
                onCreateNewRPChar(newItemState.text.toString())
                showNewRPCharPopUp.value=false
                        },
            state = newItemState
        )

        SearchFilePopup(navigateTo = { d->currentExternalDir.value=d},
            onConfirm = {

            },
            onDismiss = {
                showLoadRPCharPopUp.value=false
            },
            showDialog = showLoadRPCharPopUp.value,
            dir=currentExternalDir.value)


        Column(modifier = Modifier.fillMaxSize()) {
            MenuBar {
                MenuItem(painter = painterResource(R.drawable.ic_launcher_foreground), onClick = {})
                MenuItem{
                    Text(text="New",modifier=Modifier.clickable(onClick= {
                        showNewRPCharPopUp.value = true
                    })) //(onClick = onCreateNewProject))
                }
                MenuItem{
                    Text(text="Load",modifier=Modifier.clickable(onClick = {
                        showLoadRPCharPopUp.value=true
                    }))
                }
            }

            for(i in rpCharList.indices){
                RPCharCard(rpCharList[i]) { ch ->
                    onRPCharLoad(ch)//TODO mostrar popup de confirmacion
                }
            }
        }
    }
}