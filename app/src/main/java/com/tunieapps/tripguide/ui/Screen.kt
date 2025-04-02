package com.tunieapps.tripguide.ui

sealed class Screen(val screenTag : String) {
    data object Landing : Screen("landing")
    data object Login : Screen("login")
    data object Signup : Screen("signup")
    data object HomeContainer : Screen("homeContainer")
    data object Home : Screen("home")
}