package com.tunieapps.tripguide.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.tunieapps.tripguide.DMSansFamily

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,

    background = Color(0xFFFFFFFF),
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,

            background = Color(0xFFFFFFFF),
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)


 val bodyText = TextStyle(
    fontSize = 14.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Left,
    color = Color(0xFF828F9C)
)
val bodyTextAccent = TextStyle(
    fontSize = 14.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Left,
    color = Color(0xFFDE7254)
)
val bodyTextLight = TextStyle(
    fontSize = 14.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Normal,
    textAlign = TextAlign.Left,
    color = Color(0xFFFAF9F9)
)
val subTitle = TextStyle(
    fontSize = 12.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Medium,
    textAlign = TextAlign.Left,
    color = Color(0xFF828F9C)
)
val subTitleDark = TextStyle(
    fontSize = 12.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Medium,
    textAlign = TextAlign.Left,
    color = Color(0xFF101018)
)
val subTitleDark2 = TextStyle(
    fontSize = 10.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Left,
    color = Color(0xFF101018)
)
val heading1 = TextStyle(
    fontSize = 30.sp,
    lineHeight = 35.sp,
    color = Color(0xFF101018),
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Left
)
val heading3 = TextStyle(
    fontSize = 20.sp,
    color = Color(0xFF101018),
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Left
)
val bodyHeading = TextStyle(
    fontSize = 14.sp,
    fontFamily = DMSansFamily,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Left,
    color = Color(0xFF101018)
)

@Composable
fun TripGuideTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}