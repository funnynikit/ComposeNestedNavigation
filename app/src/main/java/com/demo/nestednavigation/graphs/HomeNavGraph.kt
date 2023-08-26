package com.demo.nestednavigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.demo.nestednavigation.BottomBarScreen
import com.demo.nestednavigation.screens.HomeScreen
import com.demo.nestednavigation.screens.InformationScreen
import com.demo.nestednavigation.screens.OverviewScreen
import com.demo.nestednavigation.screens.ProfileScreen
import com.demo.nestednavigation.screens.SettingsScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                name = BottomBarScreen.Home.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(
                name = BottomBarScreen.Profile.route,
                onClick = { }
            )
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(
                name = BottomBarScreen.Settings.route,
                onClick = { }
            )
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            InformationScreen(name = DetailsScreen.Information.route)
            {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }

        composable(route = DetailsScreen.Overview.route) {
            OverviewScreen(name = DetailsScreen.Overview.route) {
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}
