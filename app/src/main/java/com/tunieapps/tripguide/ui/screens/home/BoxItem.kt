package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil3.compose.AsyncImage
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.theme.bodyHeading
import com.tunieapps.tripguide.ui.theme.subTitle

@Composable
fun BoxItem(size: Int) {
    LazyRow {
        items(count = size) {
            Box(
                modifier = Modifier
                    .padding(start = 5.dp, end = 10.dp)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(40.dp))
            ) {
                AsyncImage(
                    model = R.drawable.park1,
                    contentDescription = "box image",
                    modifier = Modifier
                        .size(width = 161.dp, height = 206.dp)
                        .background(color = Color.Transparent, shape = RoundedCornerShape(40.dp))
                )
                Column(
                    modifier = Modifier.align(alignment = Alignment.BottomCenter)
                ) {
                    Text(
                        "Milano Park",
                        style = bodyHeading
                    )
                    Text(
                        "Saint Paulo, Milan, Italy",
                        style = subTitle
                    )

                    Row {
                        val myId = "inlineContent"
                        val text = buildAnnotatedString {
                            append("Hello")     // Append a placeholder string "[myBox]" and attach an annotation "inlineContent" on it.
                            appendInlineContent(myId, "[myBox]")
                        }
                        val inlineContent = mapOf(
                            Pair(         // This tells the [BasicText] to replace the placeholder string "[myBox]" by         // the composable given in the [InlineTextContent] object.
                                myId,
                                InlineTextContent(             // Placeholder tells text layout the expected size and vertical alignment of             // children composable.
                                    Placeholder(
                                        width = 0.5.em,
                                        height = 0.5.em,
                                        placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
                                    )
                                )
                                {             // This [Box] will fill maximum size, which is specified by the [Placeholder]             // above. Notice the width and height in [Placeholder] are specified in TextUnit,             // and are converted into pixel by text layout.
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color = Color.Red)
                                    )
                                })
                        )
                        Text(
                            text = "4.0",
                            style = subTitle
                        )
                        Text(
                            "|",
                            style = subTitle
                        )
                        Text(
                            "36 Reviews",
                            style = subTitle
                        )
                    }
                }
            }
        }
    }
}