package com.example.hojadepersonaje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.hojadepersonaje.characterdata.RPCharacter
import com.example.hojadepersonaje.ui.theme.HojaDePersonajeTheme
import com.example.hojadepersonaje.views.CharacterSheetView
import com.example.hojadepersonaje.views.MainMenuView
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            HojaDePersonajeTheme {

                val rpCharList= mutableListOf<RPCharacter>()


                Box(modifier=Modifier.windowInsetsPadding(insets= WindowInsets.statusBars))
                {
                    val backStack= remember{ mutableStateListOf<Any>(Home) }//lista que se inicia con "Home" como unico elemento, ya que es l apantalla inicial de la app
                    NavDisplay(
                        backStack=backStack,
                        onBack={
                            backStack.removeLastOrNull()},
                        entryProvider={
                                key->
                            when(key){
                                is Home-> NavEntry(key) {
                                    MainMenuView(
                                        onRPCharLoad = {ch->
                                            backStack.add(CharacterSheet(ch))
                                        },
                                        onCreateNewRPChar = {n->
                                            backStack.add(CharacterSheet(rpChar= RPCharacter(99999,n)))
                                        },
                                        rpCharList = rpCharList,

                                    )
                                }
                                is CharacterSheet->NavEntry(key){ch->

                                    val c=ch as CharacterSheet
                                    CharacterSheetView(c.rpChar,{backStack.removeLastOrNull()})

                                }
                                else->NavEntry(key=Unit){
                                    Text(text="Error de navegacion 1")//TODO Error de navegacion
                                }
                            }
                        }
                    )
                }


            }
        }
    }
    data object Home
    data class CharacterSheet(var rpChar: RPCharacter)
}

