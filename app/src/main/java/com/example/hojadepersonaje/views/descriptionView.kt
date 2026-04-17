package com.example.hojadepersonaje.views

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hojadepersonaje.characterdata.Action
import com.example.hojadepersonaje.characterdata.Item
import com.example.hojadepersonaje.characterdata.Spell
import com.example.hojadepersonaje.characterdata.Weapon
import com.example.hojadepersonaje.composables.DescriptionCard


@JvmName("DescriptionView")
@Composable
private fun DescriptionView(cards:List<DescriptionCard>){

}

@JvmName("WeaponsDescriptionView")
@Composable
fun DescriptionView(weapons: List<Weapon>,addNew:()->Unit){

    LazyColumn(modifier= Modifier.fillMaxHeight(0.8f)) {
        items(weapons){
            weapon->
            DescriptionCard(weapon.name){
                Text(text=weapon.description)
            }
        }
    }
    TextButton(onClick = {addNew()}) {
        Text("Add")
    }
}

@JvmName("ItemsDescriptionList")
@Composable
fun DescriptionView(items: List<Item>,addNew:()->Unit){

}

@JvmName("SpellsDescriptionList")
@Composable
fun DescriptionView(spells: List<Spell>,addNew:()->Unit){

}

@JvmName("ActionsDescriptionView")
@Composable
fun DescriptionView(actions:List<Action>,addNew:()->Unit){
     /*LazyColumn(modifier=Modifier.fillMaxHeight(0.8f)) {
        items(actions){
            action->
            DescriptionCard(action.description){
                Text(action.description)
            }
        }

    }*/
    TextButton(onClick = {addNew()},modifier=Modifier.fillMaxSize()) {
        Text("Add")
    }
}