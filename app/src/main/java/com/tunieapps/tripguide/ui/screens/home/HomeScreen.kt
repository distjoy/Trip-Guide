package com.tunieapps.tripguide.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.SearchInputField
import com.tunieapps.tripguide.ui.TgFilledTextField
import com.tunieapps.tripguide.ui.TgOutlinedTextField
import com.tunieapps.tripguide.ui.textAndInlineContent
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyHeading
import com.tunieapps.tripguide.ui.theme.bodyText
import com.tunieapps.tripguide.ui.theme.heading1
import com.tunieapps.tripguide.ui.theme.heading3
import com.tunieapps.tripguide.ui.theme.subTitle
import com.tunieapps.tripguide.ui.theme.white
import kotlin.math.abs


@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), launcher: (screen: Screen) -> Unit) {
    val menu = listOf(
        AppNavItem(1, R.drawable.home_line, R.drawable.home_filled, true),
        AppNavItem(1, R.drawable.heart_line, R.drawable.heart_line, true),
        AppNavItem(1, R.drawable.notification_line, R.drawable.notification_line, true),
        AppNavItem(1, R.drawable.profile_line, R.drawable.profile_line, true)
    )
    val scrollState = rememberScrollState()
    val pair = remember { mutableStateOf(Pair(0, 0)) }
    val originalPos = remember { mutableStateOf(Pair(-1, -1)) }
    val st = with(LocalDensity.current) {
        WindowInsets.statusBars.getBottom(this) + 20.dp.roundToPx().toFloat()
    }

    LaunchedEffect(Unit) {
        viewModel.getPlaces()
    }

    val lazyListState = rememberLazyListState()

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {

                val new = pair.value.second + available.y.toInt()

                if (new <= 0) {
                    if ((originalPos.value.second - st) >= abs(new)) {
                        pair.value = Pair(0, pair.value.second + available.y.toInt())

                    }

                }

                return Offset.Zero
            }
        }
    }
    Scaffold(
        modifier = Modifier
            .background(color = Color(0xFFFAF9F9))
            .nestedScroll(nestedScrollConnection)
            .safeDrawingPadding(),
        topBar = {
            TopBar({ x: Int, y: Int ->
                if (originalPos.value.second == -1 || originalPos.value.first == -1)
                    originalPos.value = Pair(x, y)
            }, pair)
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .padding(top = 0.dp, bottom = 0.dp)
                    .background(color = Color(0xFFFAF9F9))
                    .shadow(
                        35.dp, RoundedCornerShape(
                            CornerSize(0.dp)
                        ), ambientColor = Color(0xFF2A2A2A),
                        spotColor = Color(0xFF2A2A2A)
                    ),
                containerColor = Color(0xFFFAF9F9),
                contentColor = Color(0xFFDE7254),
                tonalElevation = 2.dp
            ) {

                menu.forEach({

                    val icon = if (it.isSelected) {
                        it.selectedIcon
                    } else it.defaultIcon

                    NavigationBarItem(
                        selected = false,
                        onClick = { launcher(Screen.Home) },
                        icon = {
                            Image(
                                painter = painterResource(id = icon),
                                contentDescription = "Discover places banner",
                                Modifier
                                    .height(24.dp)
                                    .width(24.dp),
                                colorFilter = ColorFilter.tint(Color(0xFFDE7254))
                            )
                        },
                        enabled = true,
                        alwaysShowLabel = false,
                        modifier = Modifier

                    )

                })
            }

        },
        containerColor = Color(0xFFFAF9F9),
        contentWindowInsets = WindowInsets(0.dp)
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = 100.dp,
                    start = padding.calculateStartPadding(LayoutDirection.Ltr),
                    end = padding.calculateEndPadding(LayoutDirection.Ltr),
                )
        ) {

            item {
                Text(
                    "Discover Places",
                    modifier = Modifier.padding(start = 27.dp, top = 20.dp, bottom = 10.dp),
                    style = heading3
                )

                FilterChips(size = 5)
                BoxRow(viewModel.places.collectAsState().value)
                Row(
                    modifier = Modifier.padding(
                        start = 24.dp,
                        top = 30.dp,
                        bottom = 15.dp,
                        end = 24.dp
                    )
                ) {
                    Text(
                        "People Liked",
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        style = heading3
                    )
                    TextButton(
                        onClick = { },
                    ) {
                        Text(
                            "View All",
                            modifier = Modifier.padding(end = 10.dp),
                            fontSize = 16.sp,
                            color = Color(0xFFDE7254),
                            fontFamily = DMSansFamily,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Image(
                            painter =
                            painterResource(R.drawable.arrow_right), ""
                        )
                    }
                }

            }



            items(4) {
                Row(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 10.dp, bottom = 15.dp)
                        .height(IntrinsicSize.Min)
                ) {
                    AsyncImage(
                        model = R.mipmap.cafe,//"https://picsum.photos/200",//,
                        contentDescription = "box image",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .height(78.dp)
                            .width(78.dp)
                            .clip(shape = RoundedCornerShape(15.dp))
                    )

                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(1f)
                            .wrapContentHeight()
                    ) {
                        Text(
                            "Milano Cafe",
                            style = bodyHeading,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        AddressText()
                        Row(modifier = Modifier.padding(end = 10.dp)) {
                            StarText(4.0)
                            Text(
                                "|",
                                style = subTitle,
                                modifier = Modifier.padding(end = 4.dp),
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                "36 Reviews",
                                style = subTitle,
                                modifier = Modifier.padding(end = 4.dp),
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                "|",
                                style = subTitle,
                                modifier = Modifier.padding(end = 4.dp),
                                fontWeight = FontWeight.Medium
                            )
                            PriceTag()
                        }
                    }
                    OutlinedButton(
                        onClick = {

                        },
                        contentPadding = PaddingValues(0.dp), modifier = Modifier
                            .fillMaxHeight()
                            .width(30.dp),
                        border = ButtonDefaults.outlinedBorder.copy(
                            brush = SolidColor(
                                Color(
                                    0xFFE7E7EF
                                )
                            )
                        )
                    ) {
                        Image(
                            painter =
                            painterResource(R.drawable.arrow_right_angle), ""
                        )
                    }
                }
            }

        }

    }
}


@Composable
fun SearchBar() {
    SearchInputField(
        modifier = Modifier
            .padding(start = 22.dp, end = 22.dp),
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
                    .padding(vertical = 10.dp, horizontal = 10.dp),
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
fun TopBar(
    positionHandler: (x: Int, y: Int) -> Unit,
    pair: State<Pair<Int, Int>> = mutableStateOf(Pair(0, 0))
) {

    Column(modifier = Modifier
        .offset {
            IntOffset(0, pair.value.second)
        }
        .background(color = Color(0xFFFAF9F9))) {
        Row(modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp, start = 24.dp, end = 24.dp)
            .onGloballyPositioned {
                it
                    .positionInWindow()
                    .apply {
                        Log.d("onGloballyPositioned", "TopBar: ${it.size} $x $y")
                        // pair.value = Pair(y.toInt(), y.toInt()+it.size.height)
                        //pair.value = Pair(0, -200)
                        positionHandler(y.toInt(), y.toInt() + it.size.height)
                    }
            }) {
            Column(
                modifier = Modifier
                    .weight(1f, true)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    "Howday \uD83D\uDC4B Alex", fontSize = 20.sp,
                    fontFamily = DMSansFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 0.dp)
                )
                val pair = textAndInlineContent("Sant Paulo, Milan, Italy", Color(0xFFDE7254))
                Text(
                    text = pair.first,
                    inlineContent = pair.second,
                    fontSize = 14.sp,
                    color = Color(0xFFDE7254),
                    fontFamily = DMSansFamily,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(start = 0.dp, top = 8.dp)
                )
            }
            Image(
                painter = painterResource(id = R.mipmap.memoji), contentDescription = "google logo",
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 0.dp)
                    .width(56.dp)
                    .height(56.dp)
                    .align(Alignment.CenterVertically)

            )
        }

        SearchBar()
    }
}


data class AppNavItem(
    val id: Int,
    val defaultIcon: Int,
    val selectedIcon: Int,
    var isSelected: Boolean = false
)


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    TripGuideTheme {
        HomeScreen(launcher = {})
    }
}