package com.example.hizligeliomulakat.Model

import androidx.compose.ui.graphics.painter.Painter

data class NavItem(
    val icon: Painter,
    val title: String,
    val route: String
)