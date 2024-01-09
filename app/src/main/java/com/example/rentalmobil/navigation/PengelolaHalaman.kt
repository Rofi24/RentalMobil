package com.example.rentalmobil.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rentalmobil.ui.Halaman.DestinasiHome
import com.example.rentalmobil.ui.Halaman.DestinasiScreen
import com.example.rentalmobil.ui.Halaman.HomeScreen
import com.example.rentalmobil.ui.Halaman.ScreenPenyewa
import com.example.rentalmobil.ui.add.AddMobil
import com.example.rentalmobil.ui.add.DestinasiEntry
import com.example.rentalmobil.ui.detail.DetailDestination
import com.example.rentalmobil.ui.detail.DetailMobil
import com.example.rentalmobil.ui.edit.EditDestination
import com.example.rentalmobil.ui.edit.EditScreen

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
            HomeScreen(
                navigateToItemEntryMobil = { navController.navigate(DestinasiEntry.route) },
                navigateToScreenPenyewa = {navController.navigate(DestinasiScreen.route)},
                onDetailClick = { itemId ->
                    navController.navigate("${DetailDestination.route}/$itemId")
                    println("itemId: $itemId")
                }
            )
        }
        composable(DestinasiEntry.route) {
            AddMobil(navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.mobilId) {
                type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val mobilId = backStackEntry.arguments?.getString(DetailDestination.mobilId)
            mobilId?.let {
                DetailMobil(
                    navigateBack = { navController.popBackStack() },
                    navigateToEditItem = {
                        navController.navigate("${EditDestination.route}/$mobilId")
                        println("mobilId: $mobilId")
                    }
                )
            }
        }
        composable(
            route = EditDestination.routeWithArgs,
            arguments = listOf(navArgument(EditDestination.mobilId) {
                type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val mobilId = backStackEntry.arguments?.getString(EditDestination.mobilId)
            mobilId?.let {
                EditScreen(
                    navigateBack = { navController.popBackStack() },
                    onNavigateUp = { navController.navigateUp() }
                )
            }
        }
    }
}