package com.tunieapps.tripguide

import LandingScreen
import SignupScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunieapps.tripguide.ui.theme.TripGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // A surface container using the 'background' color from the theme
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "landing") {
                composable("landing") {
                    TripGuideTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color(0xFFFFFFFF)
                        ) {
                            LandingScreen(
                                {
                                    navController.navigate("signup")
                                })
                        }
                    }

                }
                composable("signup") {
                    TripGuideTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = Color(0xFFFFFFFF)
                        ) {
                            SignupScreen()
                        }

                    }
                }
            }
        }

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