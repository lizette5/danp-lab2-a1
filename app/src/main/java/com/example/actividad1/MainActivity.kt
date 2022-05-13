package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            menuPrincipal()
        }
    }

    @Composable
    fun menuPrincipal() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "botones") {
            composable("botones") { botones(navController) }
            composable("imagenes/{userName}") { backStackEntry ->
                miGaleria(navController, backStackEntry.arguments?.getString("userName"))
            }
        }

    }

    @Composable
    fun botones(navController: NavController) {
        val costa by remember { mutableStateOf("Costa") }
        val sierra by remember { mutableStateOf("Sierra") }
        val selva by remember { mutableStateOf("Selva") }


    Column(

        modifier = Modifier
            .padding(0.dp)
            .background(Color.Gray)
            .fillMaxHeight(1.5f)
            .fillMaxWidth(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "Las regiones  naturales del Perú",
            textAlign = TextAlign.Center,
            fontSize = 50.sp
        )

        Spacer(Modifier.size(20.dp, 20.dp))
        Text(

            text = "Nota :Seleccione una región para que pueda observar platos típicos de esa región ",
            textAlign = TextAlign.Justify,
            fontSize = 20.sp
        )
        Spacer(Modifier.size(20.dp, 20.dp))
        Button(

            onClick = {
                if (isValidName(costa)) {
                    navController.navigate("imagenes/${costa}")
                }
            },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
        )
        {

            Text(text = "Costa")
        }

        Spacer(Modifier.size(100.dp, 100.dp))

        Button(
            onClick = {
                if (isValidName(sierra)) {
                    navController.navigate("imagenes/${sierra}")
                }
            },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
        )
        {

            Text(text = "Sierra")
        }

        Spacer(Modifier.size(100.dp, 100.dp))

        Button(
            onClick = {
                if (isValidName(selva)) {
                    navController.navigate("imagenes/${selva}")
                }
            },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
        )
        {

            Text(text = "Selva")
        }

    }


    }

    fun isValidName(name: String): Boolean {
        return !name.trim().isNullOrEmpty() && name.all { it.isLetter() }
    }

    @Composable
    fun miGaleria(navController: NavController, userName: String?) {
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Platos tipicos de la región de  la ${userName}!",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            if (userName == "Costa") {
                LazyColumn(

                    verticalArrangement = Arrangement.spacedBy(5.dp,Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                   // verticalArrangement = Arrangement.spacedBy(0.dp),
                ) {
                    items(5) {
                        Row (
                            Modifier.background(Color.LightGray)
                                .width(400.dp)

                        ){
                            Image(
                                modifier = Modifier
                                   .requiredSize(200.dp),

                                painter = painterResource(R.drawable.tv),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Tallarines Verdes", fontSize = 30.sp)
                                Text(text = "Costa")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))

                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)

                            ) {
                            Image(
                                modifier = Modifier
                                    .requiredSize(200.dp),

                                painter = painterResource(R.drawable.saltado),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Lomo Saltado", fontSize = 30.sp)
                                Text(text = "Costa")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row (
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ){
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.escabeche),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Escabeche de pescado", fontSize = 30.sp)
                                Text(text = "Costa")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row (
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ){
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.arroz),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Arroz de mariscos", fontSize = 30.sp)
                                Text(text = "Costa")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row (
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ){
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.carapulcra),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Carapulcra", fontSize = 30.sp)
                                Text(text = "Costa")
                            }

                        }

                    }

                }
            }
            if (userName == "Sierra") {
                LazyColumn(

                    verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    // verticalArrangement = Arrangement.spacedBy(0.dp),
                ) {
                    items(5) {
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)

                        ) {
                            Image(
                                modifier = Modifier
                                    .requiredSize(200.dp),

                                painter = painterResource(R.drawable.locro),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Locro de pecho", fontSize = 30.sp)
                                Text(text = "Sierra")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))

                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)

                        ) {
                            Image(
                                modifier = Modifier
                                    .requiredSize(200.dp),

                                painter = painterResource(R.drawable.cuy),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Cuy chactado", fontSize = 30.sp)
                                Text(text = "Sierra")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ) {
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.caldoc),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Caldo de cordero", fontSize = 30.sp)
                                Text(text = "Sierra")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ) {
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.quinua),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Chupe de quinua", fontSize = 30.sp)
                                Text(text = "Sierra")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ) {
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.chupe),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Chupe de habas", fontSize = 30.sp)
                                Text(text = "Sierra")
                            }

                        }

                    }
                }
            }
            if (userName == "Selva") {
                LazyColumn(

                    verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    // verticalArrangement = Arrangement.spacedBy(0.dp),
                ) {
                    items(5) {
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)

                        ) {
                            Image(
                                modifier = Modifier
                                    .requiredSize(200.dp),

                                painter = painterResource(R.drawable.tacacho),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Tacacho con cecina", fontSize = 30.sp)
                                Text(text = "Selva")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))

                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)

                        ) {
                            Image(
                                modifier = Modifier
                                    .requiredSize(200.dp),

                                painter = painterResource(R.drawable.juane),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Juane", fontSize = 30.sp)
                                Text(text = "Selva")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ) {
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.chaufa),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Arroz chaufa charapa", fontSize = 30.sp)
                                Text(text = "Selva")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ) {
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.masato),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Masato", fontSize = 30.sp)
                                Text(text = "Selva")
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        Row(
                            Modifier.background(Color.LightGray)
                                .width(400.dp)
                        ) {
                            Image(
                                modifier = Modifier.requiredSize(200.dp),
                                painter = painterResource(R.drawable.inchicapi),
                                contentDescription = "Contact profile picture",
                            )

                            Column {
                                Text(text = "Inchicapi", fontSize = 30.sp)
                                Text(text = "Selva")
                            }

                        }

                    }
                }
            }

            }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        menuPrincipal()
    }
    /*@Preview(showBackground = true)
    @Composable
    fun DefaultPreview1() {
        botones(navController = rememberNavController())
    }
    @Preview(showBackground = true)
    @Composable
    fun VistaCosta() {
        miGaleria(navController = rememberNavController(), userName = "Costa")
    }
    */
}

