package com.example.hizligeliomulakat.Screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import com.example.hizligeliomulakat.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hizligeliomulakat.Model.Product
import com.example.hizligeliomulakat.R
import com.example.hizligeliomulakat.ViewModel.ProductListViewModel

@ExperimentalFoundationApi
@Composable
fun ListProducts(
    /*
    TODO: Burada navController ile gereken yere gidecek.
      Argüman alacak ve geri döndüğünde o argümana göre call yapacak
     */
    navController: NavController,
    modifier: Modifier
) {
    val viewModel = ProductListViewModel()
    val productList = viewModel.loadDatFromAPI(null)

    var searchBarText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp)
    ) {
        Spacer(modifier = modifier.height(25.dp))

        Column(
            modifier = modifier.fillMaxWidth()
        ) {

            TextField(
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search",
                    )
                },
                value = searchBarText,
                modifier = modifier
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(topStartPercent = 20, topEndPercent = 20)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                singleLine = true,
                placeholder = {
                    Text(text = "Ara")
                },
                onValueChange = {
                    searchBarText = it
                }
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(),
            ) {

                val configuration = LocalConfiguration.current

                val screenWidth = configuration.screenWidthDp.dp

                Divider(
                    color = colorResource(id = R.color.line_green),
                    thickness = 4.dp,
                    modifier = modifier
                        .width(screenWidth / 7)
                )
                Divider(
                    color = colorResource(id = R.color.line_blue),
                    thickness = 4.dp,
                    modifier = modifier
                        .width(screenWidth / 7)
                )
                Divider(
                    color = colorResource(id = R.color.line_orange),
                    thickness = 4.dp,
                    modifier = modifier
                        .width(screenWidth / 7)
                )
                Divider(
                    color = colorResource(id = R.color.line_red),
                    thickness = 4.dp,
                    modifier = modifier
                        .width(screenWidth / 7)
                )
                Divider(
                    color = colorResource(id = R.color.line_purple),
                    thickness = 4.dp,
                    modifier = modifier
                        .width(screenWidth / 7)
                )
                Divider(
                    color = colorResource(id = R.color.line_light_blue),
                    thickness = 4.dp,
                    modifier = modifier
                        .width(screenWidth / 6)
                )
            }
        }

        Spacer(modifier = modifier.height(15.dp))

        Card(
            modifier = modifier
                .fillMaxWidth(),
            elevation = 4.dp,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .height(IntrinsicSize.Min)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Row(
                    Modifier.clickable {
                        println("Sort")
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sort),
                        contentDescription = "Sort Icon",
                        modifier = modifier.padding(end = 8.dp)
                    )
                    Text(text = "Sırala")
                }
                Divider(
                    color = Color.Gray,
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .padding(top = 1.dp, bottom = 1.dp)
                )
                Row(
                    Modifier.clickable {
                        // TODO: Navigate To Filter Screen
                        println("Filter")
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = "Filter Icon",
                        modifier = modifier.padding(end = 8.dp)
                    )
                    Text(text = "Filtre")
                }
            }
        }

        ListProduct(
            modifier = modifier,
            products = productList
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun ListProduct(
    modifier: Modifier,
    products: List<Product>? //TODO: Non-Nullable Yap!!!
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = modifier.padding(top = 20.dp)
    ) {
        items(products!!.size) {
            Card(
                elevation = 2.dp,

                modifier = modifier
                    .padding(5.dp)
            ) {
                Column(
                    modifier = modifier
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dummy_product),
                        contentDescription = "Product Image",
                        modifier = modifier
                            .height(150.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = products[it].title,
                        modifier = modifier
                            .padding(top = 8.dp),
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = products[it].price.toString() + " TL",
                        color = colorResource(id = R.color.login_button_bg),
                        modifier = modifier
                            .padding(top = 4.dp),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = modifier.height(30.dp))
                }
            }
        }
    }
}