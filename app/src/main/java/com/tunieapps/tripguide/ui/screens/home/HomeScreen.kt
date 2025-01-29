package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.SearchInputField
import com.tunieapps.tripguide.ui.TgFilledTextField
import com.tunieapps.tripguide.ui.TgOutlinedTextField
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyText
import com.tunieapps.tripguide.ui.theme.heading1
import com.tunieapps.tripguide.ui.theme.heading3


@Composable
fun HomeScreen(launcher: (screen : Screen) -> Unit){
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {},
        containerColor = Color(0xFFFAF9F9)
    ) { padding ->
        Column(modifier = Modifier.padding(top = padding.calculateTopPadding(),
            start = padding.calculateStartPadding(LayoutDirection.Ltr)+10.dp,
            end = padding.calculateEndPadding(LayoutDirection.Ltr)+10.dp, )) {
            SearchBar()
            Text(
                "Discover Places",
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
                style = heading3
            )

            FilterChips(size = 5)
            BoxRow(size = 5)
        }

    }
}


@Composable
fun SearchBar(){
    SearchInputField(
        textVal = "Full Name",
        onValueChange = {

        },
        startIcon = {
            Image(
                painter = painterResource(id = R.drawable.search_normal),
                contentDescription = "Discover places banner",
                Modifier
                    .height(16.dp),
                colorFilter = ColorFilter.tint(Color(0xFFDE7254))
            )
        },
        endIcon = {
            Image(
                painter = painterResource(id = R.drawable.filter),
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 10.dp)
                    .background(Color(0xFFDE7254), shape = CircleShape)
                    .width(40.dp)
                    .height(40.dp)
                    .padding(vertical = 10.dp, horizontal = 10.dp)


                ,
                contentDescription = "Discover places banner",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF))
                //Modifier
                    //.fillMaxWidth(1f)
                   // .height(500.dp)
            )
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    //TopAppBar(contentPadding = AppBarDefaults.ContentPadding, backgroundColor = Color.White){
        Row {
            Column(
                modifier = Modifier
                    .weight(1f, true)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    "Howday Alex", fontSize = 16.sp,
                    fontFamily = DMSansFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 10.dp)
                )
                Text(
                    "Sant Paulo, Milan, Italy", fontSize = 14.sp,
                    fontFamily = DMSansFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 10.dp)
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.memoji), contentDescription = "google logo",
                modifier = Modifier
                    .width(66.dp)
                    .height(66.dp)
                    .align(Alignment.CenterVertically)
                    .padding(vertical = 5.dp, horizontal = 10.dp)
            )
        }
    //}
}



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    TripGuideTheme {
        HomeScreen({})
    }
}