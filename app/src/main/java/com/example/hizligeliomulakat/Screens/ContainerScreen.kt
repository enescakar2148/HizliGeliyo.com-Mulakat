package com.example.hizligeliomulakat.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hizligeliomulakat.Model.NavItem
import com.example.hizligeliomulakat.R


@ExperimentalFoundationApi
@Composable
fun ContainerScreen(
    modifier: Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                items = listOf(
                    NavItem(
                        icon = painterResource(id = R.drawable.ic_home),
                        title = "Products",
                        route = "ListProducts"
                    ),
                    NavItem(
                        icon = painterResource(id = R.drawable.ic_any_screen_icon),
                        title = "Any Screen",
                        route = "AnyScreen"
                    ),
                    NavItem(
                        icon = painterResource(id = R.drawable.cart),
                        title = "Cart",
                        route = "Cart"
                    ),
                    NavItem(
                        icon = painterResource(id = R.drawable.ic_profile),
                        title = "Profile",
                        route = "Profile"
                    )

                ),
                modifier = modifier,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Navigation(navController = navController)
    }
}

@ExperimentalFoundationApi
@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "ListProducts") {
        composable("Cart"){
            Cart(modifier = Modifier)
        }
        composable("Profile"){
            Profile(modifier = Modifier)
        }
        composable("AnyScreen"){
            AnyScreen(modifier = Modifier)
        }
        composable("ListProducts"){
            ListProducts(modifier = Modifier, navController = navController)
        }
    }

}

@Composable
fun BottomBar(
    navController: NavController,
    items: List<NavItem>,
    modifier: Modifier,
    onItemClick: (NavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.line_orange),
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = colorResource(id = R.color.line_orange),
                unselectedContentColor = Color.LightGray,
                onClick = {
                    onItemClick(item)
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = "Products"
                    )
                }
            )

        }
    }
}

