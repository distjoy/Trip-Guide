package com.tunieapps.tripguide.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableChipBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tunieapps.tripguide.ui.theme.bodyText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(size: Int,onclick : () -> Unit={}){

    LazyRow {
        items(count = size){
            FilterChip(
                modifier = Modifier.padding(paddingValues = PaddingValues(end = 10.dp)),
                onClick = onclick,
                label = {
                    Text("Filter chip", style = bodyText)
                },
                selected = false,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                },
                shape = RoundedCornerShape(CornerSize(30.dp)),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.Transparent,
                labelColor = Color(0xFF828F9C),
            iconColor = Color(0xFF828F9C),
            disabledContainerColor = Color.Transparent
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderColor = Color(0xFFE7E7EF)
                )

            )
        }
    }
}
