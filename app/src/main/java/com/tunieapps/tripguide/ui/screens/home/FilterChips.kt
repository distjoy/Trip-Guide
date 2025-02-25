package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.model.PlaceType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(types: List<PlaceType>,onSelected: (type: PlaceType) -> Unit) {


    LazyRow(modifier = Modifier.padding(top = 10.dp)) {
        items(count = types.size) { index ->
            val type = types[index]
            FilterChip(
                modifier = Modifier
                    .padding(paddingValues = PaddingValues(start = 27.dp, end = 0.dp))

                ,
                onClick = {
                    onSelected(type)
                },
                label = {
                    //Material2 Text color not functional with M3 FilterChip - SelectableChipColors so using Material3 Text instead
                    Text(type.displayName,
                        fontSize = 14.sp,
                        fontFamily = DMSansFamily,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(end = 14.dp))
                },
                selected = type.selected,
                leadingIcon = {
                    Icon(
                        imageVector =  ImageVector.vectorResource(id = type.icon),
                        contentDescription = "Done icon",
                        modifier = Modifier.padding(top = 12.dp, bottom = 12.dp,start = 14.dp) .size(FilterChipDefaults.IconSize)
                    )
                },
                shape = RoundedCornerShape(30.dp),

                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.Transparent,
                    labelColor = Color(0xFF828F9C),
                    iconColor = Color(0xFF828F9C),
                    disabledContainerColor = Color.Transparent,
                    disabledLabelColor = Color(0xFF828F9C),
                    disabledLeadingIconColor = Color(0xFF828F9C),
                    disabledTrailingIconColor = Color(0xFF828F9C),
                    selectedContainerColor = Color(0xFFDE7254),
                    disabledSelectedContainerColor = Color(0xFFDE7254),
                    selectedLabelColor = Color(0xFFFAF9F9),
                    selectedLeadingIconColor = Color(0xFFFAF9F9),
                    selectedTrailingIconColor = Color(0xFFFAF9F9),

                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = Color(0xFFE7E7EF),
                    selectedBorderColor = Color(0xFFDE7254),
                    disabledBorderColor = Color(0xFFE7E7EF),
                    disabledSelectedBorderColor = Color(0xFFDE7254),
                    borderWidth = 1.dp,
                    selectedBorderWidth = 1.dp
                )

            )
        }
    }
}
