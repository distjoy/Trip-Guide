package com.tunieapps.tripguide

import LandingScreen
import LoginScreen
import SignupScreen
import android.os.Bundle
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.screens.AppContainer
import com.tunieapps.tripguide.ui.screens.home.AppNavItem
import com.tunieapps.tripguide.ui.screens.home.HomeScreen
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.abs

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    setContent {


            // A surface container using the 'background' color from the theme
            val navController = rememberNavController()
           /* AppContainer() {


            }*/
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
                           /* HomeScreen {
                                navigator(navController, it)
                            }*/
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
