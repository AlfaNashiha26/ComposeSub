package com.example.tvwatchlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tvwatchlist.ui.navigation.Screen
import com.example.tvwatchlist.ui.screen.ProfileScreen
import com.example.tvwatchlist.ui.screen.detail.DetailScreen
import com.example.tvwatchlist.ui.screen.list.ListScreen
import com.example.tvwatchlist.ui.theme.TVWatchlistTheme

@Composable
fun TVWatchlistApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.List.route,
    ) {
        composable(Screen.List.route) {
            ListScreen(
                navigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                },
                navigateToDetail = { seriesId ->
                    navController.navigate(Screen.Detail.createRoute(seriesId))
                }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(onBackClick = { navController.navigateUp() })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("seriesId") { type = NavType.StringType}),
        ) {
            val id = it.arguments?.getString("seriesId") ?: "0"
            DetailScreen(
                seriesId = id,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TVWatchlistAppPreview() {
    TVWatchlistTheme {
        TVWatchlistApp()
    }
}