package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.screens.HomeContainer
import com.tunieapps.tripguide.ui.theme.TripGuideTheme


@Composable
fun HomeScreenWrapper( function: (screen: Screen) -> Unit) {

    val navController = rememberNavController()

    HomeContainer({ screen -> navController.navigate(screen.screenTag) }) { padding ->
        NavHost(navController = navController, startDestination = Screen.Home.screenTag) {
            composable(Screen.Home.screenTag) {
                TripGuideTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color(0xFFFFFFFF)
                    ) {
                        HomeScreen(padding) {
                            navController.navigate(it.screenTag)
                        }
                    }

                }
            }

        }
    }


}