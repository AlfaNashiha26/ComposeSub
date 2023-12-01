package com.example.tvwatchlist.ui.navigation

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("list/{seriesId}") {
        fun createRoute(seriesId: String) = "list/$seriesId"
    }
    object Profile : Screen("profile")
}
