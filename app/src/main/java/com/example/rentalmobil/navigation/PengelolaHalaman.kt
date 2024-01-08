package com.example.rentalmobil.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rentalmobil.ui.Halaman.DestinasiHome
import com.example.rentalmobil.ui.Halaman.HomeScreen
import com.example.rentalmobil.ui.add.AddMobil
import com.example.rentalmobil.ui.add.DestinasiEntry
import com.example.rentalmobil.ui.detail.DetailDestination

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(
            DestinasiHome.route
        ) {
            HomeScreen(navigateToItemEntry = {
                navController.navigate(DestinasiEntry.route)
            },
                onDetailClick = { itemId ->
                    navController.navigate("${DetailDestination.route}/$itemId")
                    println("itemId: $itemId")
                }
            )
        }
        composable(DestinasiEntry.route) {
            AddMobil(navigateBack = {
                navController.popBackStack()
            })

        }
    }
}