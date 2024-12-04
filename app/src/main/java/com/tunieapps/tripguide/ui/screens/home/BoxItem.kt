package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tunieapps.tripguide.R

@Composable
fun BoxItem(size : Int){
    LazyRow {
        items(count = size){
            Box(modifier = Modifier.padding(start = 5.dp, end = 10.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(40.dp))) {
                Image(painter = painterResource(id = R.drawable.park1),
                    contentDescription = "box image",
                    modifier = Modifier.size(width = 161.dp, height = 206.dp)
                        .background(color = Color.Transparent, shape = RoundedCornerShape(40.dp))
                )
            }
        }
    }
}