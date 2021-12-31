package com.example.hizligeliomulakat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hizligeliomulakat.Screens.ListProducts
import com.example.hizligeliomulakat.Screens.Login
import com.example.hizligeliomulakat.ui.theme.HizliGelioMulakatTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HizliGelioMulakatTheme(
                darkTheme = false
            ) {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {

                    NavHost(navController = navController, startDestination = "Login") {
                        composable("Login"){
                            Login(modifier = Modifier, navController = navController)
                        }
                        composable("ListProducts"){
                            ListProducts(modifier = Modifier, navController = navController)
                        }
                    }
                }
            }
        }
    }
}
