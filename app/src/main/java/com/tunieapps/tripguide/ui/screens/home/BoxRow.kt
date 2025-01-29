package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil3.compose.AsyncImage
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyHeading
import com.tunieapps.tripguide.ui.theme.subTitle
import com.tunieapps.tripguide.ui.theme.white

@Composable
fun BoxRow(size: Int) {
    LazyRow(modifier = Modifier.padding(top = 20.dp)) {
        items(count = size) {
            Box(
                modifier = Modifier
                    .padding(start = 5.dp, end = 10.dp)
                    .size(161.dp, 206.dp)
            ) {
                AsyncImage(
                    model = R.drawable.park1,//"https://picsum.photos/200",//,
                    contentDescription = "box image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(206.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                )
                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = white)
                        .padding(5.dp)

                ) {
                    Text(
                        "Milano Park",
                        style = bodyHeading,
                        modifier = Modifier.padding(end = 10.dp, bottom = 5.dp)
                    )
                    AddressText()
                    Row {
                        StarText()
                        Text(
                            "|",
                            style = subTitle,
                            modifier = Modifier.padding(end = 2.dp),
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            "36 Reviews",
                            style = subTitle,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StarText() {
    val myId = "ratingStar"
    val text = buildAnnotatedString {
        appendInlineContent(myId, "[star]")
        append("4.0")
    }
    val inlineContent = mapOf(
        Pair(
            myId,
            InlineTextContent(
                Placeholder(
                    width = 1.2.em,
                    height = 1.2.em,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                )
            )
            {
                Image(
                    painter = painterResource(R.drawable.star),
                    "",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 2.dp)
                        .background(color = Color.Transparent)
                )
            })
    )
    Text(
        text = text,
        inlineContent = inlineContent,
        style = subTitle,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(end = 2.dp)
    )
}


@Composable
fun AddressText() {
    val myId = "addressIcon"
    val text = buildAnnotatedString {
        appendInlineContent(myId, "[address]")
        append("Saint Paulo, Milan, Italy")
    }
    val inlineContent = mapOf(
        Pair(
            myId,
            InlineTextContent(
                Placeholder(
                    width = 1.2.em,
                    height = 1.2.em,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                )
            )
            {
                Image(
                    painter = painterResource(R.drawable.location),
                    "",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 2.dp)
                        .background(color = Color.Transparent)
                )
            })
    )
    Text(
        text = text,
        inlineContent = inlineContent,
        style = subTitle,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(bottom = 3.dp)
    )

}

@Composable
@Preview(showBackground = true)
fun BoxRowPreview(){
    TripGuideTheme {
        BoxRow(5)
    }
}