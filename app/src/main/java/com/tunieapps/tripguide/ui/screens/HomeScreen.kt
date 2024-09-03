package com.tunieapps.tripguide.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.theme.TripGuideTheme


@Composable
fun HomeScreen(launcher: (screen : Screen) -> Unit){
    Row {

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    TripGuideTheme {
        HomeScreen({})
    }
}