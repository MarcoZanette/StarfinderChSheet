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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hojadepersonaje.ui.theme.HojaDePersonajeTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            HojaDePersonajeTheme {

                Box(modifier=Modifier.windowInsetsPadding(insets= WindowInsets.statusBars))
                {
                    val navController:NavHostController=rememberNavController()

                    NavHost(navController=navController,startDestination=MainMenu){

                        composable<MainMenu>{
                            val chList:MutableList<Character>

                        }

                    }
                }
            }
        }
    }
}

@Serializable
object MainMenu

@Serializable
data class NewChView(val chName:String)

@Serializable
data class ChView(val chId:String)
