package com.tunieapps.tripguide.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R

@Composable
fun TgOutlinedTextField( textVal : String,onValueChange : (String) -> Unit ){
    OutlinedTextField(
        value = textVal,
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(vertical = 10.dp)),
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Left,
            color = Color(0xFF828F9C),
        ), onValueChange = onValueChange,
        shape = RoundedCornerShape(CornerSize(30.dp)),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xFFE7E7EF))
    )
}

@Composable
fun TgPrimaryButton(text : String, onClick : ()-> Unit){
    Button(
        onClick,
        Modifier
            .fillMaxWidth()
            .padding(PaddingValues(vertical = 10.dp)),
        colors = ButtonDefaults.buttonColors(
            Color(0xFFDE7254),
            Color(0xFFFFFFFF),
            Color(0xC9DE7254),
            Color(0xC9FFFFFF),
        )
    ) {

        Text(
            text, fontSize = 16.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TgOutlinedImageButton(text : String, drawableId : Int, onClick : ()-> Unit){
    OutlinedButton(onClick = onClick,
        Modifier.padding(top = 10.dp)
            .fillMaxWidth()
        ,
        border = BorderStroke(1.dp,Color(0xFFE7E7EF)),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff000000))
    ) {
        Image(painter = painterResource(id =drawableId), contentDescription = "google logo",
            modifier = Modifier.align(Alignment.CenterVertically).padding(vertical = 5.dp)
        )
        Text(
            text, fontSize = 16.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 10.dp )
        )
    }
}