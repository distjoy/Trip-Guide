package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.theme.bodyHeading
import com.tunieapps.tripguide.ui.theme.subTitle


@Composable
fun LikedPlaces(){

    Column(modifier = Modifier.padding(start = 24.dp)) {

        Row(
            modifier = Modifier
                .padding(start = 0.dp, end = 10.dp, bottom = 15.dp)
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
                Row( modifier = Modifier.padding(end = 10.dp)) {
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
            OutlinedButton (onClick = {

            },
                contentPadding = PaddingValues(0.dp),modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp),
                border = ButtonDefaults.outlinedBorder.copy(brush = SolidColor(Color(0xFFE7E7EF)))) {
                Image(painter =
                painterResource(  R.drawable.arrow_right_angle),"")
            }
        }


        Row(
            modifier = Modifier
                .padding(start = 0.dp, end = 10.dp, bottom = 15.dp)
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
                Row( modifier = Modifier.padding(end = 10.dp)) {
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
            OutlinedButton (onClick = {

            },
                contentPadding = PaddingValues(0.dp),modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp),
                border = ButtonDefaults.outlinedBorder.copy(brush = SolidColor(Color(0xFFE7E7EF)))) {
                Image(painter =
                painterResource(  R.drawable.arrow_right_angle),"")
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 0.dp, end = 10.dp, bottom = 15.dp)
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
                Row( modifier = Modifier.padding(end = 10.dp)) {
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
            OutlinedButton (onClick = {

            },
                contentPadding = PaddingValues(0.dp),modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp),
                border = ButtonDefaults.outlinedBorder.copy(brush = SolidColor(Color(0xFFE7E7EF)))) {
                Image(painter =
                painterResource(  R.drawable.arrow_right_angle),"")
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 0.dp, end = 10.dp, bottom = 15.dp)
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
                Row( modifier = Modifier.padding(end = 10.dp)) {
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
            OutlinedButton (onClick = {

            },
                contentPadding = PaddingValues(0.dp),modifier = Modifier
                    .fillMaxHeight()
                    .width(30.dp),
                border = ButtonDefaults.outlinedBorder.copy(brush = SolidColor(Color(0xFFE7E7EF)))) {
                Image(painter =
                painterResource(  R.drawable.arrow_right_angle),"")
            }
        }


    }
}