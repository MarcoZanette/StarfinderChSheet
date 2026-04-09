package com.example.hojadepersonaje.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
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
fun DescriptionView(weapons: List<Weapon>){

    LazyColumn(modifier= Modifier) {
        items(weapons){
            weapon->
            DescriptionCard(weapon.name){
                Text(text=weapon.description)
            }
        }
    }
}

@JvmName("ItemsDescriptionList")
@Composable
fun DescriptionView(items: List<Item>){

}

@JvmName("SpellsDescriptionList")
@Composable
fun DescriptionView(spells: List<Spell>){

}

@JvmName("ActionsDescriptionView")
@Composable
fun DescriptionView(actions:List<Action>){
    LazyColumn(modifier=Modifier) {
        items(actions){
            action->
            DescriptionCard(action.description){
                Text(action.description)
            }
        }
    }
}