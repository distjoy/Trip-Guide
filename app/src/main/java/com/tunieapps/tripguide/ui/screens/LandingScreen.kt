import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.TgPrimaryButton
import com.tunieapps.tripguide.ui.screens.HomeScreen
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyText
import com.tunieapps.tripguide.ui.theme.heading1

@Composable
fun LandingScreen(launcher: (screen : Screen) -> Unit) {

    // Row
    // Image - Banner
    // Page Title
    // Page Body
    // Page Button, Login
    // Page Button, Sign up

    Column(modifier = Modifier.padding(15.dp)) {
        Image(
            bitmap = ImageBitmap.Companion.imageResource(id = R.mipmap.onboarding_banner),
            contentDescription = "Discover places banner",
            Modifier
                .fillMaxWidth(1f)
                .height(500.dp)
        )
        Text(
            text = "Discover best places to go to vacation \uD83D\uDE0D",
            style = heading1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 10.dp))
        )
        Text(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vitae sapien viverra laoreet fusce cras nibh. ",
            style = bodyText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 0.dp))
        )
        TgPrimaryButton(
            onClick = {
                launcher(Screen.Login)
            },
            text = "Login"
        )

        OutlinedButton(
            onClick = { launcher(Screen.Signup)},
            Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 0.dp)),
            border = BorderStroke(1.dp, Color(0xFFE7E7EF)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff000000))
        ) {
            Text(
                "Sign Up", fontSize = 16.sp,
                fontFamily = DMSansFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }


}
@Composable
@Preview(showBackground = true)
fun LandingScreenPreview(){
    TripGuideTheme {
        LandingScreen({})
    }
}

