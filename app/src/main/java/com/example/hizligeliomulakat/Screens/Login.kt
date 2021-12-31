package com.example.hizligeliomulakat.Screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hizligeliomulakat.R

@Composable
fun Login(
    modifier: Modifier,
    navController: NavController
) {

    var password by remember {
        mutableStateOf("")
    }

    var mail by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_back_arrow),
            contentDescription = "Login Back Button",
            modifier = modifier
                .padding(top = 50.dp, start = 30.dp)
        )

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.login_logo),
                contentDescription = "Company Logo",
                modifier = Modifier
                    .size(120.dp)
            )
            Text(
                text = "Hesabına Giriş Yap",
                fontSize = 24.sp,
                fontWeight = FontWeight.W500,
                modifier = modifier.padding(bottom = 25.dp, top = 5.dp),
                color = colorResource(id = R.color.account_login_text)
            )

            TextField(
                value = mail,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = modifier
                    .padding(horizontal = 35.dp, vertical = 10.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(50)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                onValueChange = {
                    mail = it
                },
                placeholder = {
                    Text(
                        text = "demo@hizligeliyo.com",
                        modifier = modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )

            TextField(
                value = password,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = modifier
                    .padding(horizontal = 35.dp, vertical = 10.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(50)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                onValueChange = {
                    password = it
                },
                placeholder = {
                    Text(
                        text = "* * * * * *",
                        modifier = modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
            Text(
                text = "Şifremi Unuttum",
                color = colorResource(id = R.color.account_login_text),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp, vertical = 10.dp),
                textAlign = TextAlign.End
            )

            Button(
                onClick = {
                    navController.navigate("ListProducts")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.login_button_bg)
                ),
                modifier = modifier
                    .width(200.dp)
                    .height(60.dp)
                    .padding(top = 15.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = "Giriş Yap",
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier.padding(top = 12.dp)
            ) {
                Text(
                    text = "Hesabın Yok Mu? ",
                    color = colorResource(id = R.color.account_login_text)
                )
                Text(
                    text = "Kaydol",
                    color = colorResource(id = R.color.login_button_bg)
                )
            }
        }

        Row(
            modifier = modifier
                .fillMaxWidth().padding(top = 150.dp),
        ) {

            val configuration = LocalConfiguration.current

            val screenWidth = configuration.screenWidthDp.dp

            Divider(
                color = colorResource(id = R.color.line_green),
                thickness = 10.dp,
                modifier = modifier
                    .width(screenWidth / 6)
            )
            Divider(
                color = colorResource(id = R.color.line_blue),
                thickness = 10.dp,
                modifier = modifier
                    .width(screenWidth / 6)
            )
            Divider(
                color = colorResource(id = R.color.line_orange),
                thickness = 10.dp,
                modifier = modifier
                    .width(screenWidth / 6)
            )
            Divider(
                color = colorResource(id = R.color.line_red),
                thickness = 10.dp,
                modifier = modifier
                    .width(screenWidth / 6)
            )
            Divider(
                color = colorResource(id = R.color.line_purple),
                thickness = 10.dp,
                modifier = modifier
                    .width(screenWidth / 6)
            )
            Divider(
                color = colorResource(id = R.color.line_light_blue),
                thickness = 10.dp,
                modifier = modifier
                    .width(screenWidth / 6)
            )
        }
    }
}