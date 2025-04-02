import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.TgOutlinedImageButton
import com.tunieapps.tripguide.ui.TgOutlinedTextField
import com.tunieapps.tripguide.ui.TgPrimaryButton
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyText
import com.tunieapps.tripguide.ui.theme.heading1

@Composable
fun LoginScreen(launcher : (screen : Screen) -> Unit) {
    Scaffold(
        modifier = Modifier
            .background(color = Color(0xFFFAF9F9))
            .safeDrawingPadding(),
        topBar = { },
        bottomBar = {},
        containerColor = Color(0xFFFAF9F9),
        contentWindowInsets = WindowInsets(0.dp)
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(
                top = padding.calculateTopPadding()+15.dp,
                start = padding.calculateStartPadding(LayoutDirection.Ltr) + 10.dp,
                end = padding.calculateEndPadding(LayoutDirection.Ltr) + 10.dp,
            )
        ) {
            Text(
                text = "Login",
                style = heading1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(vertical = 10.dp))
            )
            Text(
                "Welcome! Please enter your Name, email and password to create your account.",
                style = bodyText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(vertical = 0.dp))
            )

            TgOutlinedTextField(
                textVal = "Email Address",
                onValueChange = {

                }
            )

            TgOutlinedTextField(
                textVal = "Your Password",
                onValueChange = {

                }
            )

            TgPrimaryButton(
                text = "Login",
                onClick = {
                    launcher.invoke(Screen.HomeContainer)
                }
            )

            TgOutlinedImageButton(text = "Login with google",
                drawableId = R.drawable.flat_color_icons_google,
                onClick = { /*TODO*/ })
        }
    }

}

@Composable
@Preview(showBackground = true)
fun LoginPreview() {
    TripGuideTheme {
        LoginScreen({})
    }
}