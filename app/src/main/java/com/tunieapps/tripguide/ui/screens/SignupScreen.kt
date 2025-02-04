import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.OutlinedTextFieldDecorationBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.ui.Screen
import com.tunieapps.tripguide.ui.TgOutlinedTextField
import com.tunieapps.tripguide.ui.TgOutlinedTextField2
import com.tunieapps.tripguide.ui.TgPrimaryButton
import com.tunieapps.tripguide.ui.screens.home.TopBar
import com.tunieapps.tripguide.ui.theme.TripGuideTheme
import com.tunieapps.tripguide.ui.theme.bodyText
import com.tunieapps.tripguide.ui.theme.heading1

@Composable
fun SignupScreen(launcher: (screen : Screen) -> Unit) {
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
                text = "Signup",
                style = heading1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(vertical = 10.dp))
            )
            Text(
                "Welcome! Please enter your Name, email and password to create your account.",
                style = bodyText
            )

            TgOutlinedTextField(
                textVal = "Full Name",
                onValueChange = {

                })

            TgOutlinedTextField(
                textVal = "Email Address",
                onValueChange = {

                })

            TgOutlinedTextField(
                textVal = "Your Password",
                onValueChange = {

                }
            )
            //OutlinedTextFieldDecorationBox()

            TgOutlinedTextField(textVal = "Re-enter Password ",
                onValueChange = {

                }
            )

            TgPrimaryButton(
                text = "Sign Up",
                onClick = { /*TODO*/ }
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun SignupPreview() {
    TripGuideTheme {
        SignupScreen({})
    }
}