package com.tunieapps.tripguide

import LandingScreen
import LoginScreen
import SignupScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.screens.home.HomeScreen
import com.tunieapps.tripguide.ui.theme.TripGuideTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // A surface container using the 'background' color from the theme
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screen.Landing.screenTag) {
                composable(Screen.Landing.screenTag) {
                    TripGuideTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color(0xFFFFFFFF)
                        ) {
                            LandingScreen {
                                navigator(navController, it)
                            }
                        }
                    }

                }
                composable(Screen.Signup.screenTag) {
                    TripGuideTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color(0xFFFFFFFF)
                        ) {
                            SignupScreen {
                                navigator(navController, it)
                            }
                        }

                    }
                }
                composable(Screen.Login.screenTag) {
                    TripGuideTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color(0xFFFFFFFF)
                        ) {
                            LoginScreen {
                                navigator(navController, it)
                            }
                        }

                    }
                }
                composable(Screen.Home.screenTag) {
                    TripGuideTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color(0xFFFFFFFF)
                        ) {
                            HomeScreen {
                                navigator(navController, it)
                            }
                        }

                    }
                }
            }
        }

    }

    fun navigator(controller: NavController, screen: Screen){
        controller.navigate(screen.screenTag)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TripGuideTheme {
        LandingScreen({})
    }
}

val DMSansFamily = FontFamily(
    Font(R.font.dmsans_light, FontWeight.Light),
    Font(R.font.dmsans_regular, FontWeight.Normal),
    Font(R.font.dmsans_medium, FontWeight.Medium),
    Font(R.font.dmsans_bold, FontWeight.Bold)
)
