package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import com.tunieapps.tripguide.model.Place
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyHeading
import com.tunieapps.tripguide.ui.theme.subTitle
import com.tunieapps.tripguide.ui.theme.subTitleDark
import com.tunieapps.tripguide.ui.theme.white

@Composable
fun BoxRow(places : List<Place>) {
    LazyRow(modifier = Modifier.padding(top = 20.dp).height(206.dp)) {
        items(count = places.size) { index ->
            val place = places[index]

            Box(
                modifier = Modifier
                    .padding(start = 24.dp, end = 0.dp)
                    .height(206.dp)
                    .width(intrinsicSize = IntrinsicSize.Min)
            ) {
                AsyncImage(
                    model = place.photo,
                    contentDescription = "box image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(181.dp)
                        .height(206.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                )
                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .padding(5.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = white)
                        .padding(5.dp)

                ) {
                    Text(
                        place.displayName,
                        style = bodyHeading,
                        modifier = Modifier.padding(end = 10.dp, bottom = 5.dp)
                    )
                    AddressText(place.address)
                    Row {
                        StarText(place.ratings)
                        Text(
                            "|",
                            style = subTitle,
                            modifier = Modifier.padding(end = 2.dp),
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            "${place.reviews} Reviews",
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
fun PriceTag() {
   Row {
       Text(
           text = "$40.0",
           style = subTitleDark,
           fontWeight = FontWeight.SemiBold
       )
       Text(
           "/night",
           style = subTitle,
           fontWeight = FontWeight.Medium
       )
   }


}

@Composable
fun StarText(rating : Double ) {
    val myId = "ratingStar"
    val text = buildAnnotatedString {
        appendInlineContent(myId, "[star]")
        append(rating.toString())
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
        modifier = Modifier.padding(end = 4.dp)
    )
}

@Composable
fun AddressText(address : String) {
    val myId = "addressIcon"
    val text = buildAnnotatedString {
        appendInlineContent(myId, "[address]")
        append(address)
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
        modifier = Modifier.padding(bottom = 10.dp)
    )

}

@Composable
@Preview(showBackground = true)
fun BoxRowPreview(){
    TripGuideTheme {
        BoxRow(listOf(Place("","Test name","type", emptyList(),
            "",4.00,345,"")))
    }
}