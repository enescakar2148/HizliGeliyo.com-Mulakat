package com.example.hizligeliomulakat.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ListProducts(
    navController: NavController,
    modifier: Modifier
) {
    Column() {
        Text(text = "List Products")
    }
}