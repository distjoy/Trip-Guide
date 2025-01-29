package com.tunieapps.tripguide.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding

import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily


@Composable
fun TgOutlinedTextField( textVal : String,onValueChange : (String) -> Unit,
                         startIcon :  @Composable() (() -> Unit)? = null,endIcon :  @Composable() (() -> Unit)? = null){
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        enabled = true,
        value = value,
        label = {Text(text = textVal)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues( vertical =  10.dp)),
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Left,
            color = Color(0xFF101018),
        ), onValueChange = {
            value = it
            onValueChange(it)
        },
        leadingIcon = startIcon,
        trailingIcon = endIcon,

        shape = RoundedCornerShape(CornerSize(30.dp)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0x00FFFFFF),
            unfocusedContainerColor = Color(0x00FFFFFF),
            disabledContainerColor = Color(0x00FFFFFF),
            unfocusedLabelColor = Color(0xFF828F9C),
            focusedLabelColor = Color(0xFF828F9C),
            disabledLabelColor = Color(0xFF828F9C),
            disabledIndicatorColor = Color(0xFFE7E7EF),
            unfocusedIndicatorColor = Color(0xFFE7E7EF),
            focusedIndicatorColor = Color(0xFFE7E7EF),

            )
    )
}

@Composable
fun TgFilledTextField( textVal : String,onValueChange : (String) -> Unit,
                         startIcon :  @Composable() (() -> Unit)? = null,endIcon :  @Composable() (() -> Unit)? = null){
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        enabled = true,
        value = value,
        label = {Text(text = textVal)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues( vertical =  10.dp)),
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Left,
            color = Color(0xFF101018),
        ), onValueChange = {
            value = it
            onValueChange(it)
        },
        leadingIcon = startIcon,
        trailingIcon = endIcon,

        shape = RoundedCornerShape(CornerSize(30.dp)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFFFFFF),
            unfocusedContainerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF),
            unfocusedLabelColor = Color(0xFF828F9C),
            focusedLabelColor = Color(0xFF828F9C),
            disabledLabelColor = Color(0xFF828F9C),
            focusedBorderColor = Color(0xFFFFFFFF),
            unfocusedBorderColor = Color(0xFFFFFFFF),
            disabledBorderColor = Color(0xFFFFFFFF),

            )
    )
}

@Composable
fun SearchInputField( textVal : String,onValueChange : (String) -> Unit,
                       startIcon :  @Composable() (() -> Unit)? = null,endIcon :  @Composable() (() -> Unit)? = null){
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        enabled = true,
        value = value,
        label = {Text(text = textVal)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues( vertical =  10.dp))

            .shadow(5.dp, RoundedCornerShape(CornerSize(35.dp)), ambientColor = Color(0xFFFFFFFF),
                spotColor = Color(0xFFEAEAEA) )
            .background(color = Color(0xFFFFFFFF) ),
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Left,
            color = Color(0xFF101018),
        ), onValueChange = {
            value = it
            onValueChange(it)
        },
        leadingIcon = startIcon,
        trailingIcon = endIcon,

        shape = RoundedCornerShape(CornerSize(30.dp)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFFFFFF),
            unfocusedContainerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF),
            unfocusedLabelColor = Color(0xFF828F9C),
            focusedLabelColor = Color(0xFF828F9C),
            disabledLabelColor = Color(0xFF828F9C),
            focusedBorderColor = Color(0xFFFFFFFF),
            unfocusedBorderColor = Color(0xFFFFFFFF),
            disabledBorderColor = Color(0xFFFFFFFF),

            )
    )
}


internal fun Modifier.outlineCutout(labelSize: Size, paddingValues: PaddingValues) =
    this.drawWithContent {
        val labelWidth = labelSize.width
        if (labelWidth > 0f) {
            val innerPadding = 4.dp.toPx()
            val leftLtr = paddingValues.calculateLeftPadding(layoutDirection).toPx() - innerPadding
            val rightLtr = leftLtr + labelWidth + 2 * innerPadding
            val left = when (layoutDirection) {
                LayoutDirection.Rtl -> size.width - rightLtr
                else -> leftLtr.coerceAtLeast(0f)
            }
            val right = when (layoutDirection) {
                LayoutDirection.Rtl -> size.width - leftLtr.coerceAtLeast(0f)
                else -> rightLtr
            }
            val labelHeight = labelSize.height
            // using label height as a cutout area to make sure that no hairline artifacts are
            // left when we clip the border
            clipRect(left, -labelHeight / 2, right, labelHeight / 2, ClipOp.Difference) {
                this@drawWithContent.drawContent()
            }
        } else {
            this@drawWithContent.drawContent()
        }
    }


@Composable
fun TgPrimaryButton(text: String, onClick: () -> Unit) {
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
fun TgOutlinedImageButton(text: String, drawableId: Int, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color(0xFFE7E7EF)),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff000000))
    ) {
        Image(
            painter = painterResource(id = drawableId), contentDescription = "google logo",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(vertical = 5.dp)
        )
        Text(
            text, fontSize = 16.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .padding(start = 10.dp)
        )
    }
}